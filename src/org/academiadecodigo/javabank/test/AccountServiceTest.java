package org.academiadecodigo.javabank.test;

<<<<<<< HEAD:src/org/academiadecodigo/javabank/test/AccountManagerTest.java
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
=======
import org.academiadecodigo.javabank.model.account.CheckingAccount;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.model.account.SavingsAccount;
import org.academiadecodigo.javabank.services.AccountServiceImpl;
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae:src/org/academiadecodigo/javabank/test/AccountServiceTest.java

public class AccountServiceTest {

    public boolean test() {

<<<<<<< HEAD:src/org/academiadecodigo/javabank/test/AccountManagerTest.java
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
=======
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
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae:src/org/academiadecodigo/javabank/test/AccountServiceTest.java
        if (ac.getBalance() != 10 || as.getBalance() != SavingsAccount.MIN_BALANCE + 10) {
            return false;
        }

        // should be able to withdraw
<<<<<<< HEAD:src/org/academiadecodigo/javabank/test/AccountManagerTest.java
<<<<<<< HEAD
        accountService.withdraw(ac.getId(), 1);
=======
        accountManager.withdraw(ac.getId(), 1);
>>>>>>> 4613278b5a80940ea4a6d11598a61558e591800d
=======
        accountService.withdraw(ac.getId(), 1);
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae:src/org/academiadecodigo/javabank/test/AccountServiceTest.java
        if (ac.getBalance() != 9) {
            return false;
        }

        // should be able to transfer if sufficient funds are available
<<<<<<< HEAD:src/org/academiadecodigo/javabank/test/AccountManagerTest.java
<<<<<<< HEAD
        accountService.transfer(as.getId(), ac.getId(), 1);
=======
        accountManager.transfer(as.getId(), ac.getId(), 1);
>>>>>>> 4613278b5a80940ea4a6d11598a61558e591800d
=======
        accountService.transfer(as.getId(), ac.getId(), 1);
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae:src/org/academiadecodigo/javabank/test/AccountServiceTest.java
        if (ac.getBalance() != 10 || as.getBalance() != SavingsAccount.MIN_BALANCE + 9) {
            return false;
        }

        // should not be able to transfer if available funds are not sufficient in savings
<<<<<<< HEAD:src/org/academiadecodigo/javabank/test/AccountManagerTest.java
<<<<<<< HEAD
        accountService.transfer(as.getId(), ac.getId(), 10);
=======
        accountManager.transfer(as.getId(), ac.getId(), 10);
>>>>>>> 4613278b5a80940ea4a6d11598a61558e591800d
=======
        accountService.transfer(as.getId(), ac.getId(), 10);
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae:src/org/academiadecodigo/javabank/test/AccountServiceTest.java
        if (ac.getBalance() != 10 || as.getBalance() != SavingsAccount.MIN_BALANCE + 9) {
            return false;
        }

        // should not be able to transfer if available funds are not sufficient in checking
<<<<<<< HEAD:src/org/academiadecodigo/javabank/test/AccountManagerTest.java
<<<<<<< HEAD
        accountService.transfer(ac.getId(), as.getId(), 11);
=======
        accountManager.transfer(ac.getId(), as.getId(), 11);
>>>>>>> 4613278b5a80940ea4a6d11598a61558e591800d
=======
        accountService.transfer(ac.getId(), as.getId(), 11);
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae:src/org/academiadecodigo/javabank/test/AccountServiceTest.java
        if (ac.getBalance() != 10 || as.getBalance() != SavingsAccount.MIN_BALANCE + 9) {
            return false;
        }

        return true;
    }
}
