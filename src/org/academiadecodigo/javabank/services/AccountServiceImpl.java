package org.academiadecodigo.javabank.services;

<<<<<<< HEAD:src/org/academiadecodigo/javabank/managers/AccountManager.java
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.domain.account.SavingsAccount;
import org.academiadecodigo.javabank.factories.AccountFactory;

=======
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;

import java.util.Collections;
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae:src/org/academiadecodigo/javabank/services/AccountServiceImpl.java
import java.util.HashMap;
import java.util.Map;

public class AccountServiceImpl implements AccountService {

    private Map<Integer, Account> accountMap = new HashMap<>();

    public void add(Account account) {

<<<<<<< HEAD:src/org/academiadecodigo/javabank/managers/AccountManager.java
    public Account openAccount(AccountType accountType) {
        Account newAccount = accountFactory.createAccount(accountType);
        accountMap.put(newAccount.getId(), newAccount);
        return newAccount;
=======
        if (account.getId() == null) {
            account.setId(getNextId());
        }

        accountMap.put(account.getId(), account);
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae:src/org/academiadecodigo/javabank/services/AccountServiceImpl.java
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
