package org.academiadecodigo.javabank.controller.services.servicebd;


import org.academiadecodigo.javabank.controller.model.Customer;
import org.academiadecodigo.javabank.controller.model.account.Account;
import org.academiadecodigo.javabank.controller.services.AccountService;
import org.academiadecodigo.javabank.controller.services.AuthService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AccountServiceBD implements AccountService {

    public AccountServiceBD(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void setAuthService(AuthService authService) {

    }

    private Map<Integer, Account> accountMap = new HashMap<>();
    private EntityManagerFactory emf;

    @SuppressWarnings("Duplicates")
    public Account add(Account account) {


        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            Account savedAccount = em.merge(account);
            em.getTransaction().commit();
            return savedAccount;

        } catch (RollbackException ex) {

            em.getTransaction().rollback();
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void deposit(int id, double amount) {
        //em.find(Account.class, id).credit(amount);
        // accountMap.get(id).credit(amount);
    }

    public void withdraw(int id, double amount) {

     /*   Account account = em.find(Account.class, id);
            if (em.find(AccountType.)){

            }

     /*   Account account = accountMap.get(id);
        if (account.getAccountType() == AccountType.SAVINGS) {
            return;
        }

        accountMap.get(id).debit(amount);
     */}

    public void transfer ( int srcId, int dstId, double amount){

        Account srcAccount = accountMap.get(srcId);
        Account dstAccount = accountMap.get(dstId);

        // make sure transaction can be performed
        if (srcAccount.canDebit(amount) && dstAccount.canCredit(amount)) {
            srcAccount.debit(amount);
            dstAccount.credit(amount);
        }
    }

    private Integer getNextId() {
        return accountMap.isEmpty() ? 1 : Collections.max(accountMap.keySet()) + 1;
    }
}
