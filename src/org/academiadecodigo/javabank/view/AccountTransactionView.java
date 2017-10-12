package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.javabank.controller.transaction.AccountTransactionController;

public class AccountTransactionView extends AbstractView {

    private AccountTransactionController transactionController;

    @Override
    public void show() {

<<<<<<< HEAD
        if (customerService.getLoginCustomer().getAccountIds().size() == 0) {
=======
        if (transactionController.getAccountIds().size() == 0) {
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
            showNoAccounts();
            return;
        }

        showAccounts();

        transactionController.submitTransaction(scanAccount(), scanAmount());
    }

    public void showNoAccounts() {
        System.out.println("\n" + Messages.VIEW_ACCOUNT_TRANSACTION_NOACCOUNT_ERROR);
    }

    public void showAccounts() {
        System.out.println("\n" + Messages.VIEW_ACCOUNT_TRANSACTION_ACCOUNTS_MESSAGE + buildAccountList());
    }

    private String buildAccountList() {

        StringBuilder builder = new StringBuilder();

<<<<<<< HEAD
        for (Integer id : customerService.getLoginCustomer().getAccountIds()) {
=======
        for (Integer id : transactionController.getAccountIds()) {
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
            builder.append(id);
            builder.append(" ");
        }

        return builder.toString();
    }

    private int scanAccount() {

<<<<<<< HEAD
        Customer customer = customerService.getLoginCustomer();
        IntegerSetInputScanner scanner = new IntegerSetInputScanner(customer.getAccountIds());
=======
        IntegerSetInputScanner scanner = new IntegerSetInputScanner(transactionController.getAccountIds());
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
        scanner.setMessage(Messages.VIEW_ACCOUNT_TRANSACTION_ACCOUNTID_MESSAGE);
        scanner.setError(Messages.VIEW_ACCOUNT_TRANSACTION_INVALID_ACCOUNT_ERROR);
        return prompt.getUserInput(scanner);

    }

    private double scanAmount() {

        DoubleInputScanner scanner = new DoubleInputScanner();
        scanner.setMessage(Messages.VIEW_ACCOUNT_TRANSACTION_AMOUNT_MESSAGE);
        scanner.setError(Messages.VIEW_ACCOUNT_TRANSACTION_INVALID_AMOUNT_ERROR);
        return prompt.getUserInput(scanner);
    }

    public void setTransactionController(AccountTransactionController transactionController) {
        this.transactionController = transactionController;
    }
}
