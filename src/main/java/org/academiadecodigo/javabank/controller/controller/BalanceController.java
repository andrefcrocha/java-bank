package org.academiadecodigo.javabank.controller.controller;

import org.academiadecodigo.javabank.controller.model.Customer;
import org.academiadecodigo.javabank.controller.services.CustomerService;

public class BalanceController extends AbstractController {

    CustomerService customerService;

    public Customer getCustomer() {
        return authService.getAccessingCustomer();
    }

    public double getCustomerBalance() {
       return customerService.getBalance(authService.getAccessingCustomer().getId());
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
