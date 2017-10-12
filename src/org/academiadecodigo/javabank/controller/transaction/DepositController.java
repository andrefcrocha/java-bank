package org.academiadecodigo.javabank.controller.transaction;

public class DepositController extends AbstractAccountTransactionController {

    @Override
    public void submitTransaction(int accountId, double amount) {
<<<<<<< HEAD
        customerService.getAccountService().deposit(accountId, amount);
=======
        accountService.deposit(accountId, amount);
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
    }
}
