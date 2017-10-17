package org.academiadecodigo.javabank.persistence.doa.jpa;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.manager.JpaSessionManager;
import java.util.List;

public class JpaCustomerDao extends JpaGenericDao<Customer> implements CustomerDao {

    private JpaSessionManager sm;

    public void setSm(JpaSessionManager sm) {
        this.sm = sm;
    }

    @Override
    public List<Account> getbalance(Integer id) {

        Customer customer = sm.getCurrentSession().find(Customer.class, id);
        List<Account> accounts = customer.getAccounts();

        return accounts;
    }

     @Override
    public List<Integer> getCustomerAccountIds(Integer id) {

        Customer customer = sm.getCurrentSession().find(Customer.class, id);
        List<Account> accounts = customer.getAccounts();
        List<Integer> accountIds = sm.getCurrentSession().createQuery("select Account.id from " + accounts).getResultList();

        return accountIds;
    }
}
