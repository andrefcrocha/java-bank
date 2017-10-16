package org.academiadecodigo.javabank.controller.services;

import org.academiadecodigo.javabank.controller.model.account.Account;
import org.academiadecodigo.javabank.controller.model.account.AccountType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AccountServiceImpl implements AccountService {

    private Map<Integer, Account> accountMap = new HashMap<>();

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    private AuthService authService;

    public Account add(Account account) {

        if (account.getId() == null) {
            account.setId(getNextId());
        }

        return accountMap.put(account.getId(), account);
    }

    public void deposit(int id, double amount) {
        accountMap.get(id).credit(amount);
    }

    public void withdraw(int id, double amount) {

        Account account = accountMap.get(id);
        if (account.getAccountType() == AccountType.SAVINGS) {
            return;
        }

        accountMap.get(id).debit(amount);
    }

    public void transfer(int srcId, int dstId, double amount) {

        Account srcAccount = accountMap.get(srcId);
        Account dstAccount = accountMap.get(dstId);

        // make sure transaction can be performed
        if (srcAccount.canDebit(amount) && dstAccount.canCredit(amount)) {
            srcAccount.debit(amount);
            dstAccount.credit(amount);
        }
    }

    private Integer getNextId() {
        return accountMap.isEmpty() ? 1 : Collections.max(accountMap.keySet()) + 1;
    }
}