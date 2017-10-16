package org.academiadecodigo.javabank.persistence.doa;

import org.academiadecodigo.javabank.model.AbstractModel;

import java.util.List;

public interface DAO<T extends AbstractModel> {

    T findOne(int id);

    List<T> findAll();

    public void create(T entity);

    public void update(T entity);

    public void delete(T entity);

    public void deleteById(int entityId);

}
