package org.academiadecodigo.javabank.controller.services.servicebd;

import org.academiadecodigo.javabank.controller.model.Customer;
import org.academiadecodigo.javabank.controller.services.AuthService;
import org.academiadecodigo.javabank.controller.services.CustomerService;

public class AuthServiceBD implements AuthService {

    private Customer accesingCustomer;
    private CustomerService customerService;

    @Override
    public boolean authenticate(Integer id) {

        accesingCustomer = customerService.findById(id);
        return accesingCustomer != null;
    }

    @Override
    public Customer getAccessingCustomer() {
        return accesingCustomer;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
