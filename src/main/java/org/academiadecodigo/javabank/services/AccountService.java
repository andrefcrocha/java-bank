package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.doa.jpa.AccountDao;

public interface AccountService extends AccountDao {

    void deposit(Integer id, double amount);

    void withdraw(Integer id, double amount);

    void transfer(Integer srcId, Integer dstId, double amount);

    Account add(Account account);

}
