package org.academiadecodigo.javabank.controller.controller;

import org.academiadecodigo.javabank.controller.view.View;
import org.academiadecodigo.javabank.controller.services.AuthService;

public abstract class AbstractController implements Controller {

    protected AuthService authService;
    protected View view;

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void init() {
        view.show();
    }

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }
}
