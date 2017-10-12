package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.controller.controller.Controller;
import org.academiadecodigo.javabank.controller.controller.MainController;
import org.academiadecodigo.javabank.controller.view.UserOptions;
import org.academiadecodigo.javabank.controller.view.View;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.Mockito.never;

public class MainControllerTest {

    private MainController mainController;
    private View view;
    private Controller ctrl1;
    private Controller ctrl2;

    @Before
    public void setup(){
        mainController = new MainController();
        view = Mockito.mock(View.class);
        mainController.setView(view);

        ctrl1 = Mockito.mock(Controller.class);
        ctrl2 = Mockito.mock(Controller.class);
        Map<Integer, Controller> mapController = new HashMap<>();
    }

    @Test
    public void initTest(){
        mainController.init();
        Mockito.verify(view).show();
    }

    @Test
    public void quitMenuSelection(){

        mainController.onMenuSelection(UserOptions.QUIT.getOption());

        //UserOptions userOptions = Mockito.mock(UserOptions.class);
        //mainController.setControllerMap(mapController);
        //Mockito.when(userOptions.getOption(mapController.keySet().equals(5)));
        //Mockito.when(mapController.keySet().equals(5));
        //mainController.onMenuSelection(5);

        Mockito.verify(ctrl1, never()).init();
        Mockito.verify(ctrl2, never()).init();
        Mockito.verify(view, never()).show();

    }
}
