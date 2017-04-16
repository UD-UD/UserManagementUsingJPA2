package com.jpa2.userStore.dao;

import com.jpa2.userStore.model.User;

import java.util.List;

/**
 * Created by ud on 16/4/17.
 */
public interface UserDao {

    User findById(int id);

    User findBySSO(String sso);

    void save(User user);

    void deleteBySSO(String sso);

    List<User> findAllUsers();

}