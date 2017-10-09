package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.model.Bank;

public class LoginView implements View {

    private Bank bank;
    private Prompt prompt;
    private LoginController loginController;

    public LoginView() {
        this.prompt = new Prompt(System.in, System.out);
    }

    public int scanCustomerId() {

        IntegerSetInputScanner scanner = new IntegerSetInputScanner(bank.getCustomerIds());
        scanner.setMessage(Messages.CHOOSE_CUSTOMER);
        scanner.setError(Messages.ERROR_INVALID_CUSTOMER);
        return prompt.getUserInput(scanner);
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void show() {
        loginController.setCustomerId(scanCustomerId());
    }
}
