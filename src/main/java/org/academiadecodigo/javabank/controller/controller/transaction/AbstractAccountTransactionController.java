package org.academiadecodigo.javabank.controller.controller.transaction;

import org.academiadecodigo.javabank.controller.controller.AbstractController;
import org.academiadecodigo.javabank.controller.services.AccountService;
import org.academiadecodigo.javabank.controller.services.CustomerService;

import java.util.Set;

public abstract class AbstractAccountTransactionController extends AbstractController implements AccountTransactionController {

    CustomerService customerService;
    AccountService accountService;

    public Set<Integer> getAccountIds() {
        return customerService.getCustomerAccountNumbers(authService.getAccessingCustomer().getId());
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
