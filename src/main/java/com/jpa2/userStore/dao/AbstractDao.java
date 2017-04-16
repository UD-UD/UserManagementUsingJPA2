package com.jpa2.userStore.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by ud on 16/4/17.
 */
public abstract class AbstractDao<PK extends Serializable,T>{

   private final Class<T> persistenceClass;

    @SuppressWarnings("unchecked")  //Initializing the type of dao we are creating
    public AbstractDao(){
        this.persistenceClass =(Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
    }

    /**
     * @PersistenceContext
     * this annotation is used to specifies which type of persistence we are going to use.Out app may contain many type of persistence.
     if we do not give a name value it will use the only one persistence we are using for eg(Hibernate)
     */
    @PersistenceContext
    EntityManager entityManager;

    protected EntityManager getEntityManager(){
        return this.entityManager;
    }

    protected T getByKey(PK key) {
        return (T) entityManager.find(persistenceClass, key);
    }

    protected void persist(T entity) {
        entityManager.persist(entity);
    }

    protected void update(T entity) {
        entityManager.merge(entity);
    }

    protected void delete(T entity) {
        entityManager.remove(entity);
    }
}
