package org.academiadecodigo.javabank;

<<<<<<< HEAD
import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.model.service.CustomerService;

public class App {

    private CustomerService customerService;

    public static void main(String[] args) {

        App app = new App();
        app.bootStrap();

    }

    private void bootStrap() {

        Bootstrap bootstrap = new Bootstrap();
        customerService = bootstrap.generateTestData();

        LoginController loginController = bootstrap.wireObjects(customerService);

        // start application
        loginController.init();

    }

=======
import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;

public class App {

    public static void main(String[] args) {

        Bank bank = new Bank();
        AccountManager accountManager = new AccountManager();
        bank.setAccountManager(accountManager);

        Customer c1 = new Customer(1,"Rui");
        Customer c2 = new Customer(2,"Sergio");
        Customer c3 = new Customer(3,"Bruno");
        bank.addCustomer(c1);
        bank.addCustomer(c2);
        bank.addCustomer(c3);

        BankApplication bankApplication = new BankApplication(bank);
        bankApplication.start();
    }
>>>>>>> 4613278b5a80940ea4a6d11598a61558e591800d
}
