package org.academiadecodigo.javabank.classtestes;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.classtestes.CreateAccount;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.CheckingAccount;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class TestInterface {

    public static void main(String args[]){

        CreateAccount createAccount = new CreateAccount();
       
       
       
        Prompt prompt = new Prompt(System.in, System.out);
        IntegerInputScanner scanner = new IntegerInputScanner();
        DoubleInputScanner scanner4 = new DoubleInputScanner();
        AccountManager accountManager = new AccountManager();
        Account account = new CheckingAccount(1);
        Bank bank = new Bank(accountManager);
        Customer c1 = new Customer(1);
        Customer c2 = new Customer(2);
        bank.addCustomer(c1);
        bank.addCustomer(c2);

        IntegerSetInputScanner scanner3 = new IntegerSetInputScanner(bank.getCustomerIds());


        String[] options = {"Create Account", "Deposit", "Withdraw", "Transfer", "Quit"};
        MenuInputScanner scanner2 = new MenuInputScanner(options);



        if (prompt.getUserInput(scanner3) == c1.getId()){
            c1.setAccountManager(accountManager);
            scanner2.setMessage("Choose an option: ");
        }else {
            c2.setAccountManager(accountManager);
            scanner2.setMessage("Choose an option: ");

        }
         int option = prompt.getUserInput(scanner2);

         if (option == 1) {
             createAccount.openAccount();
             scanner2.setMessage("Choose an option: ");
         }
         else if(option == 2) {
             int accountId = accountManager.openAccount(AccountType.CHECKING).getId();
             accountManager.deposit(accountId, prompt.getUserInput(scanner4));
             scanner2.setMessage("Choose an option: ");
         }
         else if(option == 3) {
             accountManager.withdraw(account.getId(), prompt.getUserInput(scanner4));
             scanner2.setMessage("Choose an option: ");
         }
         else if(option == 4) {



        }
    }


}
