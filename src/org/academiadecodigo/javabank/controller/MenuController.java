package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.view.View;

public class MenuController implements Controller {

    View view;
    MenuInputScanner menuInputScanner;

    public void setMenuController(MenuInputScanner menuInputScanner){
        this.menuInputScanner = menuInputScanner;

    }

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void init() {
        view.show();
    }
}
