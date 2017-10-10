package org.academiadecodigo.javabank.model.service;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;

import java.util.HashMap;
import java.util.Set;

public class CustomerService {

    private AccountService accountService;
    private HashMap<Integer, Customer> customers;
    private Customer customer;

    private int loginCustomer;

    public CustomerService() {
        this.customers = new HashMap<>();
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }


    public void addAccount(Account account) {
        customer.getAccountMap().put(account.getId(), account);
    }

    public Set<Integer> getCustomerIds() {
        return customers.keySet();
    }

    public HashMap<Integer, Customer> getCustomers() {
        return customers;
    }

    public double getBalance() {

        double balance = 0;

        for (Customer customer : customers.values()) {
            balance += customer.getBalance();
        }

        return balance;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public Customer getLoginCustomer() {
        return customers.get(loginCustomer);
    }

    public int getCustomerById(){
        return getLoginCustomer().getId();
    }

    public void setLoginCustomer(int id) {
        this.loginCustomer = id;
    }
}
