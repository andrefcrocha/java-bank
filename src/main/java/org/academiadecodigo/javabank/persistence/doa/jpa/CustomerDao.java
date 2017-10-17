package org.academiadecodigo.javabank.persistence.doa.jpa;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.doa.Dao;
import java.util.List;

public interface CustomerDao extends Dao<Customer> {

    List<Account> getbalance(Integer id);

    List<Integer> getCustomerAccountIds(Integer id);
}
