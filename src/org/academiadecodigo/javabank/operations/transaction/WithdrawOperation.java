package org.academiadecodigo.javabank.operations.transaction;

import org.academiadecodigo.javabank.operations.BankApplication;

public class WithdrawOperation extends AbstractAccountTransactionOperation {

    public WithdrawOperation(BankApplication bankApplication) {
        super(bankApplication);
    }

    @Override
    public void execute() {

        super.execute();

        if (!hasAccounts()) {
            return;
        }

        Integer accountId = scanAccount();
        Double amount = scanAmount();

        if (customer.getAccountIds().contains(accountId)) {
            accountManager.withdraw(accountId, amount);
        }
    }
}
