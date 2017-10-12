package org.academiadecodigo.javabank.view;

import org.academiadecodigo.javabank.controller.BalanceController;
<<<<<<< HEAD
import org.academiadecodigo.javabank.model.service.CustomerService;
=======
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;

import java.text.DecimalFormat;
import java.util.List;

public class BalanceView implements View {

<<<<<<< HEAD
    private CustomerService customerService;
    private BalanceController balanceController;

    DecimalFormat df = new DecimalFormat("#.##");

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setBalanceController(BalanceController balanceController) {
        this.balanceController = balanceController;
    }

=======
    private BalanceController balanceController;
    DecimalFormat df = new DecimalFormat("#.##");

>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
    @Override
    public void show() {
        showBalance();
    }

    private void showBalance() {

<<<<<<< HEAD
        //balanceController.getCustomer();
        //Customer customer = customerService.getLoginCustomer();
        System.out.println("\n" + balanceController.getCustomer().getName() + Messages.VIEW_BALANCE_MESSAGE + "\n");

        //Set<Account> accounts = customer.getAccounts();
        //for (Account account : accounts) {
        if(balanceController.validAccount()){
=======
        Customer customer = balanceController.getCustomer();
        System.out.println("\n" + customer.getName() + Messages.VIEW_BALANCE_MESSAGE + "\n");

        List<Account> accounts = customer.getAccounts();
        for (Account account : accounts) {
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
            System.out.println(account.getId() + "\t" + account.getAccountType() + "\t" + df.format(account.getBalance()));
        }

        System.out.println("\n\n" + Messages.VIEW_BALANCE_TOTAL_MESSAGE + df.format(balanceController.getCustomerBalance()));
    }

    public void setBalanceController(BalanceController balanceController) {
        this.balanceController = balanceController;
    }
}
