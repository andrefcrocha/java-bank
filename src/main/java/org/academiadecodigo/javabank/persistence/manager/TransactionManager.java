package org.academiadecodigo.javabank.persistence.manager;

public interface TransactionManager {

    public void beginRead();

    public void beginWrite();

    public void commit();

    public void rollback();

    public void setSm(SessionManager sm);
}
