package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.persistence.doa.jpa.CustomerDao;

public class AuthServiceImpl implements AuthService {

    private Integer accessingCustomerId;
    private CustomerDao customerDao;

    @Override
    public boolean authenticate(Integer id) {

        Customer customer = customerDao.findOne(id);

        if (customer == null) {
            return false;
        }

        accessingCustomerId = customer.getId();
        return true;
    }

    @Override
    public Customer getAccessingCustomer() {
        return customerDao.findOne(accessingCustomerId);
    }

    public void setCustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
