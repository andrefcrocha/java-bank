package org.academiadecodigo.javabank.classtestes;

import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;

public class CreateAccount implements Execute {

    public void openAccount(){

        AccountManager accountManager = new AccountManager();
        accountManager.openAccount(AccountType.CHECKING);
    }

    @Override
    public void execute() {
        openAccount();
    }
}