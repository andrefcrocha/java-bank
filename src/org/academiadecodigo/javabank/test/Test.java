package org.academiadecodigo.javabank.test;

public class Test {

    public static void main(String[] args) {

        Test test = new Test();
        test.testAccount();
        test.testCustomer();
        test.testAccountManager();
        test.testBank();

    }

    private static String getResult(boolean result) {
        return result ? "OK" : "FAIL";
    }

    private void testAccount() {

        CheckingAccountTest checkingAccountTest = new CheckingAccountTest();
        SavingsAccountTest savingsAccountTest = new SavingsAccountTest();
        System.out.println("Checking Account: " + Test.getResult(checkingAccountTest.test()));
        System.out.println("Savings Account: " + Test.getResult(savingsAccountTest.test()));

    }

    private void testCustomer() {
        CustomerTest customerTest = new CustomerTest();
        System.out.println("Customer: " + Test.getResult(customerTest.test()));
    }

    private void testAccountManager() {
        AccountManagerTest accountManagerTest = new AccountManagerTest();
<<<<<<< HEAD
        System.out.println("AccountService: " + Test.getResult(accountManagerTest.test()));
=======
        System.out.println("AccountManager: " + Test.getResult(accountManagerTest.test()));
>>>>>>> 4613278b5a80940ea4a6d11598a61558e591800d
    }

    private void testBank() {
        BankTest bankTest = new BankTest();
<<<<<<< HEAD
        System.out.println("CustomerService: " + Test.getResult(bankTest.test()));
=======
        System.out.println("Bank: " + Test.getResult(bankTest.test()));
>>>>>>> 4613278b5a80940ea4a6d11598a61558e591800d
    }
}
