package org.academiadecodigo.javabank.controller.transaction;

public class WithdrawalController extends AbstractAccountTransactionController {

    @Override
    public void submitTransaction(int accountId, double amount) {
<<<<<<< HEAD
        customerService.getAccountService().withdraw(accountId, amount);
=======
        accountService.withdraw(accountId, amount);
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
    }
}
