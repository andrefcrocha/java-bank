package org.academiadecodigo.javabank.factories;

<<<<<<< HEAD
import org.academiadecodigo.javabank.model.account.*;
import org.academiadecodigo.javabank.model.account.CheckingAccount;
=======
import org.academiadecodigo.javabank.domain.account.*;
import org.academiadecodigo.javabank.domain.account.CheckingAccount;
>>>>>>> 4613278b5a80940ea4a6d11598a61558e591800d

public class AccountFactory {

    private int nextAccountId = 1;

    public Account createAccount(AccountType accountType) {

        Account newAccount;
        switch (accountType) {
            case CHECKING:
                newAccount = new CheckingAccount(getNextId());
                break;
            case SAVINGS:
                newAccount = new SavingsAccount(getNextId());
                break;
            default:
                newAccount = null;

        }

        return newAccount;
    }

    private int getNextId() {
        return nextAccountId++;
    }
}
