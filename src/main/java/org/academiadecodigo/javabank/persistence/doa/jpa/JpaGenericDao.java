package org.academiadecodigo.javabank.persistence.doa.jpa;

import org.academiadecodigo.javabank.model.AbstractModel;
import org.academiadecodigo.javabank.persistence.doa.Dao;
import org.academiadecodigo.javabank.persistence.manager.JpaSessionManager;
import javax.persistence.EntityManager;
import java.util.List;

public abstract class JpaGenericDao<T extends AbstractModel> implements Dao<T> {

    private Class<T> entity;
    private JpaSessionManager sm;

    public final void setEntity(Class<T> entity){
        this.entity = entity;
    }

    public T findOne(int id){
        return sm.getCurrentSession().find(entity, id);
    }
    public List<T> findAll(){
        return sm.getCurrentSession().createQuery("from " + entity).getResultList();
    }

    public void create(T entity){
        sm.getCurrentSession().persist(entity);
    }

    public void update(T entity){
        sm.getCurrentSession().merge(entity);
    }

    public void delete(T entity){
        sm.getCurrentSession().remove(entity);
    }
    public void deleteById(int entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }
    protected final EntityManager getCurrentSession() {
        return sm.getCurrentSession();
    }
}
