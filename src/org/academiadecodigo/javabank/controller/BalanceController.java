package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Customer;
<<<<<<< HEAD
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.service.AccountService;
import org.academiadecodigo.javabank.model.service.AutenticationService;
import org.academiadecodigo.javabank.model.service.CustomerService;

import java.util.Map;


public class BalanceController extends AbstractController {

    private CustomerService customerService;
    private AccountService accountService;
    private Map<Integer, Account> accounts;
    private AutenticationService autenticationService;


    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;

    }
        public Customer getCustomer(){
          Customer customer = customerService.getLoginCustomer();
          return customer;
    }
        public Map<Integer, Account> getAccount(){
            accounts = customerService.getLoginCustomer().getAccountMap();
            return accounts;
        }
        public boolean validAccount(int idAccount) {
            if(!(accountService.getCustomers().containsKey(idAccount))){
                return false;
            }

            loginUser = customerService.getLoginCustomer();
            return true;
        }

=======
import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.services.CustomerService;

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
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
}
