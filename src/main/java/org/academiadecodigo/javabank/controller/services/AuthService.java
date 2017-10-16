package org.academiadecodigo.javabank.controller.services;

import org.academiadecodigo.javabank.controller.model.Customer;

public interface AuthService {

    boolean authenticate(Integer id);

    Customer getAccessingCustomer();

    void setCustomerService(CustomerService customerService);

}
