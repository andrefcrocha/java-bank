package org.academiadecodigo.javabank;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.controller.MenuController;
import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.operations.BalanceOperation;
import org.academiadecodigo.javabank.operations.NewAccountOperation;
import org.academiadecodigo.javabank.operations.Operation;
import org.academiadecodigo.javabank.operations.managers.AccountManager;
import org.academiadecodigo.javabank.operations.BankApplication;
import org.academiadecodigo.javabank.operations.transaction.DepositOperation;
import org.academiadecodigo.javabank.operations.transaction.WithdrawOperation;
import org.academiadecodigo.javabank.view.LoginView;
import org.academiadecodigo.javabank.view.MenuView;
import org.academiadecodigo.javabank.view.UserOptions;

import java.util.HashMap;
import java.util.Map;

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

        /*Map<Integer, Operation> map = new HashMap<>();
        map.put(UserOptions.GET_BALANCE.getOption(), new BalanceController());
        map.put(UserOptions.DEPOSIT.getOption(), new DepositController());
        map.put(UserOptions.WITHDRAW.getOption(), new WithdrawController());
        map.put(UserOptions.OPEN_ACCOUNT.getOption(), new OpenAccountController());*/

        LoginController loginController = new LoginController();
        LoginView loginView = new LoginView();
        MenuController menuController = new MenuController();
        MenuView menuView = new MenuView();

        loginView.setLoginController(loginController);
        loginView.setBank(bank);
        loginView.show();
        loginController.setView(menuView);
        menuView.setMenuController(menuController);
        menuView.buildMainMenu();
        menuView.show();




        //BankApplication bankApplication = new BankApplication(bank);
        //bankApplication.start();
    }
}
