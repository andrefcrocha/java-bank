package org.academiadecodigo.javabank.classtestes;


import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.managers.AccountManager;

public class Withdraw implements Execute{

    public void withdraw(){
        AccountManager accountManager = new AccountManager();
        Prompt prompt = new Prompt(System.in, System.out);
        IntegerSetInputScanner scanner = new IntegerSetInputScanner(accountManager.getAccountIds().keySet());
        DoubleInputScanner scanner2 = new DoubleInputScanner();

        int id = prompt.getUserInput(scanner);
        double amount = prompt.getUserInput(scanner2);
        accountManager.withdraw(id, amount);

    }
    public void execute(){
        withdraw();
    }

}