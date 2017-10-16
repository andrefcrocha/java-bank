package org.academiadecodigo.javabank.controller.services.servicebd;

import org.academiadecodigo.javabank.controller.model.Customer;
import org.academiadecodigo.javabank.controller.model.account.Account;
import org.academiadecodigo.javabank.controller.services.CustomerService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import java.util.*;

public class CustomerServiceBD implements CustomerService {
    //private Map<Integer, Customer> customerMap = new HashMap<>();
    private EntityManagerFactory emf;

    public CustomerServiceBD(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void add(Customer customer) {

        EntityManager em = emf.createEntityManager();

        try{
            // if (customer.getId() == null) {
            //   customer.setId(getNextId());
            //}
            em.getTransaction().begin();
            em.merge(customer);
            em.getTransaction().commit();

        } catch (RollbackException ex) {

            em.getTransaction().rollback(); // something went wrong, make sure db is consistent

        } finally {
            if (em != null) {
                em.close();
            }
        }

/*        customerMap.put(customer.getId(), customer);
*/    }

    @Override
    public Customer findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Customer.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    @Override
    public List<Customer> findAll() {

        EntityManager em = emf.createEntityManager();
        try{
            return em.createQuery("from Customer", Customer.class).getResultList();
        } finally {
            if (em != null){
                em.close();
            }
        }
    }

    @Override
    public Set<Integer> getCustomerIds() {

        EntityManager em = emf.createEntityManager();
        try{
            //    return em.createQuery("select Customer.id from Customer", Customer.class).getHints().keySet();
        } finally {

        }
        return customerMap.keySet();
    }

    private Map<Integer, Customer> customerMap = new HashMap<>();

    @Override
    public double getBalance(int customerId) {

        List<Account> accounts = customerMap.get(customerId).getAccounts();

        double balance = 0;
        for (Account account : accounts) {
            balance += account.getBalance();
        }

        return balance;

    }

    @Override
    public Set<Integer> getCustomerAccountNumbers(Integer id) {

        Set<Integer> accountIds = new HashSet<>();
        List<Account> accountList = customerMap.get(id).getAccounts();

        for (Account account : accountList) {
            accountIds.add(account.getId());
        }

        return accountIds;
    }

    private Integer getNextId() {
        return customerMap.isEmpty() ? 1 : Collections.max(customerMap.keySet()) + 1;
    }
}
