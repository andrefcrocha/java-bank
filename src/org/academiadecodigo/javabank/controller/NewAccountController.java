package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.service.CustomerService;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;

public class NewAccountController extends AbstractController {

    private CustomerService customerService;
    private Integer newAccountId;

    @Override
    public void init() {

        newAccountId = createAccount();

        super.init();
    }

    private int createAccount() {

        Account newAccount = customerService.getAccountService().openAccount(AccountType.CHECKING);
      //  customerService.getLoginCustomer().getAccountMap().put(newAccountId, newAccount);
        customerService.addAccount(newAccount);
        return newAccount.getId();
    }

    public Integer getNewAccountId() {
        return newAccountId;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

}
