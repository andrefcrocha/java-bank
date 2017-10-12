package org.academiadecodigo.javabank;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controller.*;
import org.academiadecodigo.javabank.controller.transaction.DepositController;
import org.academiadecodigo.javabank.controller.transaction.WithdrawalController;
<<<<<<< HEAD
import org.academiadecodigo.javabank.model.service.AccountService;
import org.academiadecodigo.javabank.model.service.CustomerService;
import org.academiadecodigo.javabank.view.UserOptions;
import org.academiadecodigo.javabank.controller.*;
=======
import org.academiadecodigo.javabank.factories.AccountFactory;
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.AccountServiceImpl;
import org.academiadecodigo.javabank.services.AuthServiceImpl;
import org.academiadecodigo.javabank.services.CustomerServiceImpl;
import org.academiadecodigo.javabank.view.*;

import java.util.HashMap;
import java.util.Map;

public class Bootstrap {

<<<<<<< HEAD
    public CustomerService generateTestData() {

        CustomerService customerService = new CustomerService();
        AccountService accountService = new AccountService();
        customerService.setAccountService(accountService);

        Customer c1 = new Customer(1, "Rui");
        Customer c2 = new Customer(2, "Sergio");
        Customer c3 = new Customer(3, "Bruno");
        customerService.addCustomer(c1);
        customerService.addCustomer(c2);
        customerService.addCustomer(c3);

        return customerService;
    }

    public LoginController wireObjects(CustomerService customerService) {
=======
    private AuthServiceImpl authService;
    private CustomerServiceImpl customerService;
    private AccountServiceImpl accountService;

    public void loadCustomers() {

        Customer c1 = new Customer();
        Customer c2 = new Customer();
        Customer c3 = new Customer();
        c1.setName("Rui");
        c2.setName("Sergio");
        c3.setName("Bruno");
        customerService.add(c1);
        customerService.add(c2);
        customerService.add(c3);

    }

    public LoginController wireObjects() {
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae

        // attach all input to standard i/o
        Prompt prompt = new Prompt(System.in, System.out);

        // wire services
        authService.setCustomerService(customerService);

        // wire login controller and view
        LoginController loginController = new LoginController();
        LoginView loginView = new LoginView();
        loginController.setView(loginView);
<<<<<<< HEAD
        loginController.setCustomerService(customerService);
        loginView.setCustomerService(customerService);
=======
        loginController.setAuthService(authService);
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
        loginView.setLoginController(loginController);
        loginView.setPrompt(prompt);

        // wire main controller and view
        MainController mainController = new MainController();
        MainView mainView = new MainView();
<<<<<<< HEAD
        mainView.setCustomerService(customerService);
=======
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
        mainView.setPrompt(prompt);
        mainView.setMainController(mainController);
        mainController.setView(mainView);
        mainController.setAuthService(authService);
        loginController.setNextController(mainController);

        // wire balance controller and view
        BalanceController balanceController = new BalanceController();
        BalanceView balanceView = new BalanceView();
        balanceView.setBalanceController(balanceController);
        balanceController.setView(balanceView);
<<<<<<< HEAD
        balanceView.setCustomerService(customerService);
=======
        balanceController.setCustomerService(customerService);
        balanceController.setAuthService(authService);
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae

        // wire new account controller and view
        NewAccountView newAccountView = new NewAccountView();
        NewAccountController newAccountController = new NewAccountController();
<<<<<<< HEAD
        newAccountController.setCustomerService(customerService);
=======
        newAccountController.setAccountService(accountService);
        newAccountController.setAuthService(authService);
        newAccountController.setAccountFactory(new AccountFactory());
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
        newAccountController.setView(newAccountView);
        newAccountView.setNewAccountController(newAccountController);

        // wire account transactions controllers and views
        DepositController depositController = new DepositController();
        WithdrawalController withdrawalController = new WithdrawalController();
        AccountTransactionView depositView = new AccountTransactionView();
        AccountTransactionView withdrawView = new AccountTransactionView();
<<<<<<< HEAD
        depositController.setCustomerService(customerService);
        depositController.setView(depositView);
        withdrawalController.setCustomerService(customerService);
        withdrawalController.setView(withdrawView);
        depositView.setCustomerService(customerService);
        depositView.setPrompt(prompt);
        depositView.setTransactionController(depositController);
        withdrawView.setCustomerService(customerService);
=======
        depositController.setAuthService(authService);
        depositController.setAccountService(accountService);
        depositController.setCustomerService(customerService);
        depositController.setView(depositView);
        withdrawalController.setAuthService(authService);
        withdrawalController.setCustomerService(customerService);
        withdrawalController.setAccountService(accountService);
        withdrawalController.setView(withdrawView);
        depositView.setPrompt(prompt);
        depositView.setTransactionController(depositController);
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
        withdrawView.setPrompt(prompt);
        withdrawView.setTransactionController(withdrawalController);

        // setup the controller map
        Map<Integer, Controller> controllerMap = new HashMap<>();
        controllerMap.put(UserOptions.GET_BALANCE.getOption(), balanceController);
        controllerMap.put(UserOptions.OPEN_ACCOUNT.getOption(), newAccountController);
        controllerMap.put(UserOptions.DEPOSIT.getOption(), depositController);
        controllerMap.put(UserOptions.WITHDRAW.getOption(), withdrawalController);

        mainController.setControllerMap(controllerMap);

        return loginController;
    }

    public void setAuthService(AuthServiceImpl authService) {
        this.authService = authService;
    }

    public void setCustomerService(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    public void setAccountService(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }
}
