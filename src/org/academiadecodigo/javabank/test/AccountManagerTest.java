package org.academiadecodigo.javabank.test;

<<<<<<< HEAD
import org.academiadecodigo.javabank.model.service.AccountService;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.model.account.SavingsAccount;
=======
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.domain.account.SavingsAccount;
import org.academiadecodigo.javabank.managers.AccountManager;
>>>>>>> 4613278b5a80940ea4a6d11598a61558e591800d

public class AccountManagerTest {

    public boolean test() {

<<<<<<< HEAD
        AccountService accountService = new AccountService();
        Account ac = accountService.openAccount(AccountType.CHECKING);
        Account as = accountService.openAccount(AccountType.SAVINGS);

        // should be able to deposit
        accountService.deposit(ac.getId(), 10);
        accountService.deposit(as.getId(), SavingsAccount.MIN_BALANCE + 10);
=======
        AccountManager accountManager = new AccountManager();
        Account ac = accountManager.openAccount(AccountType.CHECKING);
        Account as = accountManager.openAccount(AccountType.SAVINGS);

        // should be able to deposit
        accountManager.deposit(ac.getId(), 10);
        accountManager.deposit(as.getId(), SavingsAccount.MIN_BALANCE + 10);
>>>>>>> 4613278b5a80940ea4a6d11598a61558e591800d
        if (ac.getBalance() != 10 || as.getBalance() != SavingsAccount.MIN_BALANCE + 10) {
            return false;
        }

        // should be able to withdraw
<<<<<<< HEAD
        accountService.withdraw(ac.getId(), 1);
=======
        accountManager.withdraw(ac.getId(), 1);
>>>>>>> 4613278b5a80940ea4a6d11598a61558e591800d
        if (ac.getBalance() != 9) {
            return false;
        }

        // should be able to transfer if sufficient funds are available
<<<<<<< HEAD
        accountService.transfer(as.getId(), ac.getId(), 1);
=======
        accountManager.transfer(as.getId(), ac.getId(), 1);
>>>>>>> 4613278b5a80940ea4a6d11598a61558e591800d
        if (ac.getBalance() != 10 || as.getBalance() != SavingsAccount.MIN_BALANCE + 9) {
            return false;
        }

        // should not be able to transfer if available funds are not sufficient in savings
<<<<<<< HEAD
        accountService.transfer(as.getId(), ac.getId(), 10);
=======
        accountManager.transfer(as.getId(), ac.getId(), 10);
>>>>>>> 4613278b5a80940ea4a6d11598a61558e591800d
        if (ac.getBalance() != 10 || as.getBalance() != SavingsAccount.MIN_BALANCE + 9) {
            return false;
        }

        // should not be able to transfer if available funds are not sufficient in checking
<<<<<<< HEAD
        accountService.transfer(ac.getId(), as.getId(), 11);
=======
        accountManager.transfer(ac.getId(), as.getId(), 11);
>>>>>>> 4613278b5a80940ea4a6d11598a61558e591800d
        if (ac.getBalance() != 10 || as.getBalance() != SavingsAccount.MIN_BALANCE + 9) {
            return false;
        }

        return true;
    }
}
