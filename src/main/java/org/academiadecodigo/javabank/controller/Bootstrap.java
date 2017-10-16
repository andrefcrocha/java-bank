package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controller.controller.*;
import org.academiadecodigo.javabank.controller.controller.transaction.DepositController;
import org.academiadecodigo.javabank.controller.controller.transaction.WithdrawalController;
import org.academiadecodigo.javabank.controller.factories.AccountFactory;
import org.academiadecodigo.javabank.controller.services.*;
import org.academiadecodigo.javabank.controller.services.servicebd.AccountServiceBD;
import org.academiadecodigo.javabank.controller.services.servicebd.CustomerServiceBD;
import org.academiadecodigo.javabank.controller.view.*;
import org.academiadecodigo.javabank.controller.model.Customer;

import java.util.HashMap;
import java.util.Map;

public class Bootstrap {

    private AuthService authService;
    private CustomerService customerService;
    private AccountService accountService;

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

        // attach all input to standard i/o
        Prompt prompt = new Prompt(System.in, System.out);

        // wire services
        authService.setCustomerService(customerService);

        // wire login controller and view
        LoginController loginController = new LoginController();
        LoginView loginView = new LoginView();
        loginController.setView(loginView);
        loginController.setAuthService(authService);
        loginView.setLoginController(loginController);
        loginView.setPrompt(prompt);

        ;
        // wire main controller and view
        MainController mainController = new MainController();
        MainView mainView = new MainView();
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
        balanceController.setCustomerService(customerService);
        balanceController.setAuthService(authService);

        // wire new account controller and view
        NewAccountView newAccountView = new NewAccountView();
        NewAccountController newAccountController = new NewAccountController();
        newAccountController.setAccountService(accountService);
        newAccountController.setAuthService(authService);
        newAccountController.setAccountFactory(new AccountFactory());
        newAccountController.setView(newAccountView);
        newAccountView.setNewAccountController(newAccountController);

        // wire account transactions controllers and views
        DepositController depositController = new DepositController();
        WithdrawalController withdrawalController = new WithdrawalController();
        AccountTransactionView depositView = new AccountTransactionView();
        AccountTransactionView withdrawView = new AccountTransactionView();
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

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    public void setCustomerService(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    public void setCustomerService(CustomerServiceBD customerService) {
        this.customerService = customerService;
    }

    public void setAccountService(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    public void setAccountService(AccountServiceBD accountService) {
        this.accountService = accountService;
    }
}
