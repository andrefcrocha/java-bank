package org.academiadecodigo.javabank.model;

import org.academiadecodigo.javabank.model.account.Account;
import java.util.*;

public class Customer {

    private int id;
    private String name;

    private Map<Integer, Account> accounts = new HashMap<>();

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }


     public Map<Integer, Account> getAccountMap() {
        return accounts;
    }

    public Set<Account> getAccounts() {
        return new HashSet<>(accounts.values());
    }

    public double getBalance(int id) {
        return accounts.get(id).getBalance();
    }

    public double getBalance() {

        double balance = 0;
        for (Account account : accounts.values()) {
            balance += account.getBalance();
        }

        return balance;
    }

    public Set<Integer> getAccountIds() {
        return accounts.keySet();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}


