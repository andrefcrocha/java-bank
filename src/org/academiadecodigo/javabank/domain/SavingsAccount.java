package org.academiadecodigo.javabank.domain;

public class SavingsAccount extends Account {


    private static final int MIN_SAVINGS_BALANCE = 100;

    public SavingsAccount(int id) {
        this.id = id;
    }

    @Override
    public boolean debit(double amount) {

        if (getBalance() < MIN_SAVINGS_BALANCE + amount) {
            return false;
        }

        super.debit(amount);
        return true;

    }
}



