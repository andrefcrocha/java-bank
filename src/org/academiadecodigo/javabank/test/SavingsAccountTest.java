package org.academiadecodigo.javabank.test;

<<<<<<< HEAD
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.SavingsAccount;
=======
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.SavingsAccount;
>>>>>>> 4613278b5a80940ea4a6d11598a61558e591800d

public class SavingsAccountTest {

    public boolean test() {

        Account account = new SavingsAccount(1);

        // initial balance should be zero
        if (account.getBalance() != 0) {
            return false;
        }

        // should be possible to credit account with positive value
        account.credit(SavingsAccount.MIN_BALANCE + 10);
        if (account.getBalance() != SavingsAccount.MIN_BALANCE + 10) {
            return false;
        }

        // should not be possible to debit account if no sufficient funds
        account.debit(SavingsAccount.MIN_BALANCE + 20);
        if (account.getBalance() != SavingsAccount.MIN_BALANCE + 10) {
            return false;
        }

        // should be possible to debit account if sufficient funds
        account.debit(5);
        if (account.getBalance() != SavingsAccount.MIN_BALANCE + 5) {
            return false;
        }

        // should not be possible to credit or debit negative values
        account.credit(-1);
        account.debit(-1);
        if (account.getBalance() != SavingsAccount.MIN_BALANCE + 5) {
            return false;
        }

        return true;
    }

}
