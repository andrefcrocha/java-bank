package org.academiadecodigo.javabank.controller;

<<<<<<< HEAD
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.service.CustomerService;
=======
import org.academiadecodigo.javabank.factories.AccountFactory;
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.services.AccountService;

public class NewAccountController extends AbstractController {

<<<<<<< HEAD
    private CustomerService customerService;
=======
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
    private Integer newAccountId;
    private AccountFactory accountFactory;
    private AccountService accountService;

    @Override
    public void init() {

        newAccountId = createAccount();

        super.init();
    }

    private int createAccount() {

<<<<<<< HEAD
        Account newAccount = customerService.getAccountService().openAccount(AccountType.CHECKING);
      //  customerService.getLoginCustomer().getAccountMap().put(newAccountId, newAccount);
        customerService.addAccount(newAccount);
=======
        Account newAccount = accountFactory.createAccount(AccountType.CHECKING);

        accountService.add(newAccount);
        authService.getAccessingCustomer().addAccount(newAccount);

>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
        return newAccount.getId();
    }

    public Integer getNewAccountId() {
        return newAccountId;
    }

<<<<<<< HEAD
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
=======
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
    }

    public void setAccountFactory(AccountFactory accountFactory) {
        this.accountFactory = accountFactory;
    }
}
