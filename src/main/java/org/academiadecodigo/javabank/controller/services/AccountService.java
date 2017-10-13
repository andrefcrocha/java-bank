package org.academiadecodigo.javabank.controller.services;

import org.academiadecodigo.javabank.controller.model.account.Account;

public interface AccountService {

    void add(Account account);

    void deposit(int id, double amount);

    void withdraw(int id, double amount);

    void transfer(int srcId, int dstId, double amount);

}