package org.academiadecodigo.javabank.factories;

<<<<<<< HEAD
<<<<<<< HEAD
import org.academiadecodigo.javabank.model.account.*;
import org.academiadecodigo.javabank.model.account.CheckingAccount;
=======
import org.academiadecodigo.javabank.domain.account.*;
import org.academiadecodigo.javabank.domain.account.CheckingAccount;
>>>>>>> 4613278b5a80940ea4a6d11598a61558e591800d
=======
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.model.account.CheckingAccount;
import org.academiadecodigo.javabank.model.account.SavingsAccount;
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae

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
