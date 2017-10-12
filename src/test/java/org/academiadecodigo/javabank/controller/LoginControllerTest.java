package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.controller.controller.LoginController;
import org.academiadecodigo.javabank.controller.controller.MainController;
import org.academiadecodigo.javabank.controller.services.AuthService;
import org.academiadecodigo.javabank.controller.view.View;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.never;



public class LoginControllerTest {

    private LoginController loginController;
    private View view;

    @Before
    public void setup(){
        loginController = new LoginController();
        view = Mockito.mock(View.class);
        loginController.setView(view);
    }

    @Test
    public void initTest(){
        loginController.init();
        Mockito.verify(view).show();
    }

    @Test
    public void onLoginTest(){
        AuthService authService = Mockito.mock(AuthService.class);
        MainController mainController = Mockito.mock(MainController.class);
        loginController.setNextController(mainController);
        loginController.setAuthService(authService);
        Mockito.when(authService.authenticate(1)).thenReturn(true);

        loginController.onLogin(1);

        Mockito.verify(authService).authenticate(1);
        Mockito.verify(mainController).init();
        Mockito.verify(view, never()).show();
    }

    @Test
    public void onFailLoginTest(){
        AuthService authService = Mockito.mock(AuthService.class);
        MainController mainController = Mockito.mock(MainController.class);
        loginController.setNextController(mainController);
        loginController.setAuthService(authService);
        Mockito.when(authService.authenticate(2)).thenReturn(false);

        loginController.onLogin(2);

        Mockito.verify(mainController, never()).init();
        Mockito.verify(view).show();
     }
}
