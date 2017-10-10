
package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Bank;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.view.View;

public class LoginController implements Controller {

    private Bank bank;
    private View view;
    private Customer customer;

    private Controller menuController;


    public void setCustomer(int id) {
        this.customer = bank.getCustomerById(id);
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setMenuController(Controller menuController) {
        this.menuController = menuController;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }


    @Override
    public void init() {
        //view.show();
        menuController.init();
    }
}
