package org.academiadecodigo.javabank;

<<<<<<< HEAD
import org.academiadecodigo.javabank.controller.LoginController;
<<<<<<< HEAD
import org.academiadecodigo.javabank.model.service.CustomerService;

public class App {

    private CustomerService customerService;

=======
import org.academiadecodigo.javabank.services.AccountServiceImpl;
import org.academiadecodigo.javabank.services.AuthServiceImpl;
import org.academiadecodigo.javabank.services.CustomerServiceImpl;

public class App {

>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
    public static void main(String[] args) {

        App app = new App();
        app.bootStrap();

    }

    private void bootStrap() {

        Bootstrap bootstrap = new Bootstrap();
<<<<<<< HEAD
        customerService = bootstrap.generateTestData();

        LoginController loginController = bootstrap.wireObjects(customerService);
=======
        bootstrap.setAuthService(new AuthServiceImpl());
        bootstrap.setAccountService(new AccountServiceImpl());
        bootstrap.setCustomerService(new CustomerServiceImpl());
        bootstrap.loadCustomers();

        LoginController loginController = bootstrap.wireObjects();
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae

        // start application
        loginController.init();

    }
<<<<<<< HEAD

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
=======
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
}
