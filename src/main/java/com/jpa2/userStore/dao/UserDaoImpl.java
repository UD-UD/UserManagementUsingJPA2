package com.jpa2.userStore.dao;

/**
 * Created by ud on 16/4/17.
 */


import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;

import com.jpa2.userStore.model.User;
import org.springframework.stereotype.Repository;


@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    /**
     * Using LazyInitialization "initializeCollection(user.getUserProfiles())" only
     * when we have a user we saerch for its user profiles
     */
    public User findById(int id) {
        User user = getByKey(id);
        if (user != null) {
            initializeCollection(user.getUserProfiles());
        }
        return user;
    }

    /**
     *Using a JPQL :Java Persistence Query Language  to retrieve result from EntityManager
     */
    public User findBySSO(String sso) {
        System.out.println("SSO : " + sso);
        try {
            User user = (User) getEntityManager()
                    .createQuery("SELECT u FROM User u WHERE u.ssoId LIKE :ssoId")
                    .setParameter("ssoId", sso)
                    .getSingleResult();

            if (user != null) {
                initializeCollection(user.getUserProfiles());
            }
            return user;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        List<User> users = getEntityManager()
                .createQuery("SELECT u FROM User u ORDER BY u.firstName ASC")
                .getResultList();
        return users;
    }

    public void save(User user) {
        persist(user);
    }

    public void deleteBySSO(String sso) {
        User user = (User) getEntityManager()
                .createQuery("SELECT u FROM User u WHERE u.ssoId LIKE :ssoId")
                .setParameter("ssoId", sso)
                .getSingleResult();
        delete(user);
    }

    //An alternative to Hibernate.initialize()
    protected void initializeCollection(Collection<?> collection) {
        if (collection == null) {
            return;
        }
        collection.iterator().hasNext();
    }

}
