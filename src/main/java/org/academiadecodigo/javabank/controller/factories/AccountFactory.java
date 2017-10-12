package org.academiadecodigo.javabank.controller.factories;

import org.academiadecodigo.javabank.controller.model.account.Account;
import org.academiadecodigo.javabank.controller.model.account.AccountType;
import org.academiadecodigo.javabank.controller.model.account.CheckingAccount;
import org.academiadecodigo.javabank.controller.model.account.SavingsAccount;

public class AccountFactory {

    public Account createAccount(AccountType accountType) {

        Account newAccount;
        switch (accountType) {
            case CHECKING:
                newAccount = new CheckingAccount();
                break;
            case SAVINGS:
                newAccount = new SavingsAccount();
                break;
            default:
                newAccount = null;

        }

        return newAccount;
    }
}
