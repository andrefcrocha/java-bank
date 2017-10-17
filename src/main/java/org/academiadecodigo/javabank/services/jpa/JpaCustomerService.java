package org.academiadecodigo.javabank.services.jpa;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.doa.jpa.CustomerDao;
import org.academiadecodigo.javabank.persistence.doa.jpa.JpaGenericDao;
import org.academiadecodigo.javabank.persistence.manager.JpaTransactionManager;
import org.academiadecodigo.javabank.services.CustomerService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JpaCustomerService extends JpaGenericDao<Customer> implements CustomerDao<Customer> {

    JpaTransactionManager tm;
    CustomerDao customerDao;

    public double getBalance(Integer id) {
        double balance = 0;
        try {
            tm.beginRead();

            Customer customer = customerDao.findOne(id);

            if (customer == null) {
                tm.rollback();
                throw new IllegalArgumentException("Customer does not exists");

            }

            List<Account> accounts = customerDao.getbalance(id);
            for (Account a : accounts) {
                balance += a.getBalance();
            }

            tm.commit();
            return balance;

        } catch (ExceptionWrap ex) {
        }
    }

    @Override
    public List<Integer> getCustomerAccountIds(Integer id) {

        try{
            tm.beginRead();


           /* public Set<Integer> getCustomerAccountIds(Integer id){

                try {
                    tm.beginRead();
                    Set<Integer> accountsIds = new HashSet<>();
                    Customer customer = customerDao.findOne(id);

                    if (customer == null) {
                        throw new IllegalArgumentException("Customer does not exists");
                    }

                    List<Account> accounts = customer.getAccounts();

                    for (Account account : accounts) {
                        accountsIds.add(account.getId());
                    }

                    return accountsIds;

                }finally {
                    tm.commit();
                }
            }
        }*/
        }
    }
}