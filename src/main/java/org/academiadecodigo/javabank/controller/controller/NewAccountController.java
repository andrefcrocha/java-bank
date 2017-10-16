package org.academiadecodigo.javabank.controller.controller;

import org.academiadecodigo.javabank.controller.factories.AccountFactory;
import org.academiadecodigo.javabank.controller.services.AccountService;
import org.academiadecodigo.javabank.controller.model.account.Account;
import org.academiadecodigo.javabank.controller.model.account.AccountType;

public class NewAccountController extends AbstractController {

    private Integer newAccountId;
    private AccountFactory accountFactory;
    private AccountService accountService;

    @Override
    public void init() {

       Account newAccountId = createAccount();
       super.init();
    }

    private Account createAccount() {

        Account newAccount = accountFactory.createAccount(AccountType.CHECKING);
        Account account = accountService.add(newAccount);
        authService.getAccessingCustomer().addAccount(newAccount);

        return account;
    }



    public Integer getNewAccountId() {
        return newAccountId;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setAccountFactory(AccountFactory accountFactory) {
        this.accountFactory = accountFactory;
    }
}
