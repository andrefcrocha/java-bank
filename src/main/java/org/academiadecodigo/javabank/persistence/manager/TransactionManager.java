package org.academiadecodigo.javabank.persistence.manager;

public interface TransactionManager {

    void beginRead();

    void beginWrite();

    void commit();

    void rollback();
}
