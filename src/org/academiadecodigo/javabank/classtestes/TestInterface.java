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
            public static void main(String args[]) {


                Execute execute1 = new CreateAccount();
                Execute execute2 = new Deposit();
                Execute execute3 = new Withdraw();
                Execute execute4 = new Transfer();

                AccountManager accountManager = new AccountManager();
                Bank bank = new Bank(accountManager);

                Customer c1 = new Customer(1);
                Customer c2 = new Customer(2);
                bank.addCustomer(c1);
                bank.addCustomer(c2);

                Prompt prompt = new Prompt(System.in, System.out);
                IntegerInputScanner scanner = new IntegerInputScanner();

                int option = prompt.getUserInput(scanner);
                String[] options = {"Create Account", "Deposit", "Withdraw", "Transfer", "Quit"};
                MenuInputScanner scanner2 = new MenuInputScanner(options);
                do {
                    switch (option) {
                        case 1:
                            execute1.execute();
                            break;
                        case 2:
                            execute2.execute();
                            break;
                        case 3:
                            execute3.execute();
                            break;
                        case 4:
                            execute4.execute();
                            break;
                        case 5:
                            System.exit(1);
                    }
                    while(){

                    }
                }
            }
        }
