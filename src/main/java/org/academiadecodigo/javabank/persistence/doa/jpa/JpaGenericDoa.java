package org.academiadecodigo.javabank.persistence.doa.jpa;

import org.academiadecodigo.javabank.model.AbstractModel;
import org.academiadecodigo.javabank.persistence.doa.DAO;
import org.hibernate.Session;
import java.util.List;

public abstract class JpaGenericDoa<T extends AbstractModel> implements DAO<T> {

    private Class<T> entity;

    public final void setEntity(Class<T> entity){
        this.entity = entity;
    }

    public T findOne(int id){
        return getCurrentSession().get(entity, id);
    }
    public List<T> findAll(){
        return getCurrentSession().createQuery("from " + entity).list();
    }

    public void create(T entity){
        getCurrentSession().persist(entity);
    }

    public void update(T entity){
        getCurrentSession().merge(entity);
    }

    public void delete(T entity){
        getCurrentSession().delete(entity);
    }
    public void deleteById(int entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }
    protected final Session getCurrentSession() {
        return getCurrentSession();
    }
}
