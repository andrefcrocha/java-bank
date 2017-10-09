
package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.view.View;

public class LoginController implements Controller {

    private Bank bank;
    private View view;

    public LoginController(Bank bank){
        this.bank = bank;
    }

    public void setCustomerId(int customerId){
        bank.getCustomer(customerId);
    }

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void init() {
        view.show();
    }


}
