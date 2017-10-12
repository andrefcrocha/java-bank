package org.academiadecodigo.javabank.classtestes;

import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;

public class CreateAccount implements Execute {

    public void openAccount(){

     AccountManager accountManager = new AccountManager();
     int getAccountId = accountManager.openAccount(AccountType.CHECKING).getId();
     accountManager.openAccount(AccountType.CHECKING);
    }

    @Override
    public void execute(int option) {

    }
}
