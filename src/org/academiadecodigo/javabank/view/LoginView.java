package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.javabank.controller.LoginController;

public class LoginView extends AbstractView {

    private LoginController loginController;

    @Override
    public void show() {
        showBankName();
        showLoginPrompt();
    }

    private void showBankName() {
        System.out.println("\n" + Messages.VIEW_LOGIN_WELCOME);
    }

    private void showLoginPrompt() {

<<<<<<< HEAD
        IntegerSetInputScanner scanner = new IntegerSetInputScanner(customerService.getCustomerIds());
=======
        IntegerInputScanner scanner = new IntegerInputScanner();
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
        scanner.setMessage("\n" + Messages.VIEW_LOGIN_MESSAGE);
        scanner.setError(Messages.VIEW_LOGIN_ERROR);
        loginController.onLogin(prompt.getUserInput(scanner));

    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

}
