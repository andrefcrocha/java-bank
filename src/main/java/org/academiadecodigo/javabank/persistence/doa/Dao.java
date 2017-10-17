package org.academiadecodigo.javabank.persistence.doa;

import org.academiadecodigo.javabank.model.AbstractModel;
import java.util.List;

public interface Dao<T extends AbstractModel> {

    T findOne(int id);

    List<T> findAll();

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteById(int entityId);

}
