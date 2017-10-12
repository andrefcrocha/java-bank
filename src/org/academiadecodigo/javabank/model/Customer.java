package org.academiadecodigo.javabank.model;

import org.academiadecodigo.javabank.model.account.Account;
<<<<<<< HEAD
import java.util.*;
=======

import java.util.ArrayList;
import java.util.List;
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae

public class Customer extends AbstractModel {

    private String name;
    private List<Account> accounts = new ArrayList<>();

<<<<<<< HEAD
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
=======
    public String getName() {
        return name;
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

}


