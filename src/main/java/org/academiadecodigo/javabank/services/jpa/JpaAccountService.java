package org.academiadecodigo.javabank.services.jpa;

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.doa.jpa.AccountDao;
import org.academiadecodigo.javabank.persistence.manager.JpaTransactionManager;
import javax.persistence.RollbackException;

public class JpaAccountService {


    private JpaTransactionManager tm;
    private AccountDao accountDao;

    public void deposit(Integer id, double amount) {

        try {

            tm.beginWrite();

            Account account = accountDao.findOne(id);

            if (account == null) {
                tm.rollback();
                throw new IllegalArgumentException("invalid account id");
            }

            account.credit(amount);
            accountDao.update(account);
            tm.commit();

        } catch (ExceptionWrap ex) {

            tm.rollback();

        }
    }

    public void withdraw(Integer id, double amount) {

        try {

            tm.beginWrite();

            Account account = accountDao.findOne(id);

            if (account == null) {
                tm.rollback();
                throw new IllegalArgumentException("invalid account");
            }

            account.debit(amount);
            accountDao.update(account);

            tm.commit();

        } catch (RollbackException ex) {

            tm.rollback();

        }
    }

    public Account add(Account account) {
        try {
            tm.beginWrite();

            accountDao.create(account);

            if (account == null) {
                tm.rollback();
                throw new IllegalArgumentException("invalid account");
            }
            tm.commit();

        } catch (ExceptionWrap ex) {

            tm.rollback();
        } finally {
            if (tm.getSm() != null) {
                tm.getSm().stopSession();
            }
        }
        return account;
    }

    public void transfer(Integer srcId, Integer dstId, double amount) {

    try{

        tm.beginWrite();

        Account srcAccount = accountDao.findOne(srcId);
        Account dstAccount = accountDao.findOne(dstId);


        if (srcAccount == null || dstAccount == null) {
            tm.rollback();
            throw new IllegalArgumentException("invalid account id");
        }

        if (srcAccount.canDebit(amount) && dstAccount.canCredit(amount)) {
            srcAccount.debit(amount);
            dstAccount.credit(amount);
        }

        accountDao.update(srcAccount);
        accountDao.update(dstAccount);

        tm.commit();

    } catch (ExceptionWrap ex) {

        tm.rollback();
    }

    }
}
