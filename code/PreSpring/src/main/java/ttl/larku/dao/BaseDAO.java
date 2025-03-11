package ttl.larku.dao;

import java.util.List;

public interface BaseDAO<T> {

    void update(T updateObject);

    void delete(T student);

    T insert(T newObject);

    T findById(int id);

    List<T> findAll();

}