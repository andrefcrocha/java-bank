package org.academiadecodigo.javabank.persistence.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public interface SessionManager {

    public void startSession();

    public void stopSession();

    public EntityManager getCurrentSession();

    public void setEmf(EntityManagerFactory emf);

    public void setEm(EntityManager em);


}
