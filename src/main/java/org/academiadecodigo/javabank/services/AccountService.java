package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.account.Account;

import java.util.List;

public interface AccountService {

    Integer add(Account account);

    void deposit(Integer id, double amount);

    void withdraw(Integer id, double amount);

    void transfer(Integer srcId, Integer dstId, double amount);

    List<Account> getAccounts (Integer id);

}
