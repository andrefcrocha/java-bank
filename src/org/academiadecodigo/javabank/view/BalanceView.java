package org.academiadecodigo.javabank.view;

import org.academiadecodigo.javabank.controller.BalanceController;
import org.academiadecodigo.javabank.model.service.CustomerService;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;

import java.text.DecimalFormat;
import java.util.Set;

public class BalanceView implements View {

    private CustomerService customerService;
    private BalanceController balanceController;

    DecimalFormat df = new DecimalFormat("#.##");

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setBalanceController(BalanceController balanceController) {
        this.balanceController = balanceController;
    }

    @Override
    public void show() {
        showBalance();
    }

    private void showBalance() {

        //balanceController.getCustomer();
        //Customer customer = customerService.getLoginCustomer();
        System.out.println("\n" + balanceController.getCustomer().getName() + Messages.VIEW_BALANCE_MESSAGE + "\n");

        //Set<Account> accounts = customer.getAccounts();
        //for (Account account : accounts) {
        if(balanceController.validAccount()){
            System.out.println(account.getId() + "\t" + account.getAccountType() + "\t" + df.format(account.getBalance()));
        }

        System.out.println("\n\n" + Messages.VIEW_BALANCE_TOTAL_MESSAGE + df.format(customer.getBalance()));
    }
}
