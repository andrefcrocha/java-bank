package org.academiadecodigo.javabank.controller.services;

import org.academiadecodigo.javabank.controller.model.Customer;

import java.util.List;
import java.util.Set;

public interface CustomerService {

    void add(Customer customer);

    Customer findById(Integer id);

    List<Customer> findAll();

    Set<Integer> getCustomerIds();

    double getBalance(int customerId);

    Set<Integer> getCustomerAccountNumbers(Integer id);

}