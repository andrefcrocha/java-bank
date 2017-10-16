package org.academiadecodigo.javabank.persistence.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

// responsible for managing the Session lifecycle
public class JpaSessionManager implements SessionManager {

    private EntityManagerFactory emf; // the persistence unit
    private EntityManager em; // the persistence context

    public JpaSessionManager(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public void startSession() {

        if (em == null) {
            em = emf.createEntityManager();
        }
    }

    @Override
    public void stopSession() {

        if (em != null) {
            em.close();
        }

        em = null;
    }

    @Override
    public EntityManager getCurrentSession() {
        startSession();
        return em;
    }
}