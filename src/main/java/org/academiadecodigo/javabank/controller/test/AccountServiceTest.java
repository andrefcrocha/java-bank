package org.academiadecodigo.javabank.controller.test;

import org.academiadecodigo.javabank.controller.model.account.Account;
import org.academiadecodigo.javabank.controller.model.account.CheckingAccount;
import org.academiadecodigo.javabank.controller.model.account.SavingsAccount;
import org.academiadecodigo.javabank.controller.services.AccountService;
import org.academiadecodigo.javabank.controller.services.AccountServiceImpl;

import javax.persistence.EntityManagerFactory;

public class AccountServiceTest {

    public boolean test() {

        AccountService accountService = new AccountServiceImpl();
        Account ac = new CheckingAccount();
        Account as =  new SavingsAccount();
        accountService.add(ac);
        accountService.add(as);

        // should add ids
        if (ac.getId() == null || as.getId() == null) {
            return false;
        }

        // should be able to deposit
        accountService.deposit(ac.getId(), 10);
        accountService.deposit(as.getId(), SavingsAccount.MIN_BALANCE + 10);
        if (ac.getBalance() != 10 || as.getBalance() != SavingsAccount.MIN_BALANCE + 10) {
            return false;
        }

        // should be able to withdraw
        accountService.withdraw(ac.getId(), 1);
        if (ac.getBalance() != 9) {
            return false;
        }

        // should be able to transfer if sufficient funds are available
        accountService.transfer(as.getId(), ac.getId(), 1);
        if (ac.getBalance() != 10 || as.getBalance() != SavingsAccount.MIN_BALANCE + 9) {
            return false;
        }

        // should not be able to transfer if available funds are not sufficient in savings
        accountService.transfer(as.getId(), ac.getId(), 10);
        if (ac.getBalance() != 10 || as.getBalance() != SavingsAccount.MIN_BALANCE + 9) {
            return false;
        }

        // should not be able to transfer if available funds are not sufficient in checking
        accountService.transfer(ac.getId(), as.getId(), 11);
        if (ac.getBalance() != 10 || as.getBalance() != SavingsAccount.MIN_BALANCE + 9) {
            return false;
        }

        return true;
    }
}
