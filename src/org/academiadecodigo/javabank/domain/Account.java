package org.academiadecodigo.javabank.domain;

public abstract class Account {

    protected double balance;
    protected int id;


    public void credit(double amount){
        balance += amount;
    }

    public boolean debit(double amount){
        if (amount < 0){
            return true;
        }

        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }
}
