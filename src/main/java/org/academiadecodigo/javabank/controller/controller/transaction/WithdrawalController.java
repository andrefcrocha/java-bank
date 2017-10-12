package org.academiadecodigo.javabank.controller.controller.transaction;

public class WithdrawalController extends AbstractAccountTransactionController {

    @Override
    public void submitTransaction(int accountId, double amount) {
        accountService.withdraw(accountId, amount);
    }
}
