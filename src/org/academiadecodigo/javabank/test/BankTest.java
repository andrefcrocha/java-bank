package org.academiadecodigo.javabank.test;

<<<<<<< HEAD
import org.academiadecodigo.javabank.model.service.AccountService;
import org.academiadecodigo.javabank.model.service.CustomerService;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
=======
import org.academiadecodigo.javabank.domain.*;
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.domain.account.AccountType;
>>>>>>> 4613278b5a80940ea4a6d11598a61558e591800d

public class BankTest {

    public boolean test() {

<<<<<<< HEAD
        AccountService accountService = new AccountService();
        CustomerService customerService = new CustomerService();
        customerService.setAccountService(accountService);

        Customer c1 = new Customer(1, "Rui");
        Customer c2 = new Customer(2, "Sergio");
        customerService.addCustomer(c1);
        customerService.addCustomer(c2);

        Account a1 = accountService.openAccount(AccountType.CHECKING);
        Account a2 = accountService.openAccount(AccountType.CHECKING);

        c1.addAccount(a1);
        c2.addAccount(a2);

        accountService.deposit(a1.getId(), 100);
        accountService.deposit(a2.getId(), 100);

        // customerService balance should equal sum of all customers balance
        if (customerService.getBalance() != 200) {
=======
        AccountManager accountManager = new AccountManager();
        Bank bank = new Bank();
        bank.setAccountManager(accountManager);

        Customer c1 = new Customer(1, "Rui");
        Customer c2 = new Customer(2, "Sergio");
        bank.addCustomer(c1);
        bank.addCustomer(c2);

        int a1 = c1.openAccount(AccountType.CHECKING);
        int a2 = c2.openAccount(AccountType.CHECKING);

        accountManager.deposit(a1, 100);
        accountManager.deposit(a2, 100);

        // bank balance should equal sum of all customers balance
        if (bank.getBalance() != 200) {
>>>>>>> 4613278b5a80940ea4a6d11598a61558e591800d
            return false;
        }

        return true;
    }
}
