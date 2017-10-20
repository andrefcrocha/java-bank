package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Transactional
    @Override
    public void deleteCustomer(Integer id) {
        customerDao.delete(id);
    }

    @Override
    public Customer findById(Integer id) {
        return customerDao.findById(id);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerDao.findAll();
    }

    @Override
    public double getBalance(Integer id) {

        Customer customer = customerDao.findById(id);

        if (customer == null) {
            throw new IllegalArgumentException("Customer does not exists");
        }

        List<Account> accounts = customer.getAccounts();

        double balance = 0;
        for (Account account : accounts) {
            balance += account.getBalance();
        }

        return balance;
    }

    @Override
    public Set<Integer> getCustomerAccountIds(Integer id) {

        Customer customer = customerDao.findById(id);

        if (customer == null) {
            throw new IllegalArgumentException("Customer does not exist");
        }

        Set<Integer> accountIds = new HashSet<>();
        List<Account> accounts = customer.getAccounts();

        for (Account account : accounts) {
            accountIds.add(account.getId());
        }

        return accountIds;

    }
}
