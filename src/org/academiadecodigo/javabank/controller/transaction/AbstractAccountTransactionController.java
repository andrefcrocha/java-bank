package org.academiadecodigo.javabank.controller.transaction;

import org.academiadecodigo.javabank.controller.AbstractController;
<<<<<<< HEAD
import org.academiadecodigo.javabank.model.service.CustomerService;

public abstract class AbstractAccountTransactionController extends AbstractController implements AccountTransactionController {

    protected CustomerService customerService;
=======
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.services.CustomerService;

import java.util.Set;

public abstract class AbstractAccountTransactionController extends AbstractController implements AccountTransactionController {

    CustomerService customerService;
    AccountService accountService;

    public Set<Integer> getAccountIds() {
        return customerService.getCustomerAccountNumbers(authService.getAccessingCustomer().getId());
    }
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
