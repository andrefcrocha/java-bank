package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.view.View;

public class MenuController implements Controller {

    View view;
    MenuInputScanner menuInputScanner;

    public void setMenuController(MenuInputScanner menuInputScanner){
        this.menuInputScanner = menuInputScanner;

    }

        /* private Map<Integer, Operation> buildOperationsMap() {

            Map<Integer, Operation> map = new HashMap<>();
            map.put(UserOptions.GET_BALANCE.getOption(), new BalanceController());
            map.put(UserOptions.DEPOSIT.getOption(), );
            map.put(UserOptions.WITHDRAW.getOption(), ;
            map.put(UserOptions.OPEN_ACCOUNT.getOption(), ;

            return map;

        }*/


    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void init() {
        view.show();
    }
}
