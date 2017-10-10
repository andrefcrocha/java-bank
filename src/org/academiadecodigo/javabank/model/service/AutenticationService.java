package org.academiadecodigo.javabank.model.service;


import org.academiadecodigo.javabank.model.Customer;

public class AutenticationService {

    CustomerService customerService;
    Customer loginUser;

    public boolean validCustomer(int id) {

        if(!(customerService.getCustomers().containsKey(id))){
            return false;
        }

        loginUser = customerService.getLoginCustomer();
        return true;
    }


    public Customer getLogUser() {
        return loginUser;
    }

    public int getLoginUserId(){
        return customerService.getCustomerById();
    }
}
