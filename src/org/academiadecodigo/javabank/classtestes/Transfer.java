package org.academiadecodigo.javabank.classtestes;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.managers.AccountManager;

public class Transfer implements Execute{

    public void transfer(){
        AccountManager accountManager = new AccountManager();
        Prompt prompt = new Prompt(System.in, System.out);
        IntegerSetInputScanner scanner = new IntegerSetInputScanner(accountManager.getAccountIds().keySet());
        DoubleInputScanner scanner2 = new DoubleInputScanner();

        int idsrc = prompt.getUserInput(scanner);
        int iddst = prompt.getUserInput(scanner);
        double amount = prompt.getUserInput(scanner2);
        accountManager.transfer(idsrc, iddst, amount);

    }
    public void execute(){
        transfer();
    }

}