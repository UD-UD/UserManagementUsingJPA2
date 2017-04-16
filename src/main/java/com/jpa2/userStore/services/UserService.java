package com.jpa2.userStore.services;

import com.jpa2.userStore.model.User;

import java.util.List;

/**
 * Created by ud on 16/4/17.
 */
public interface UserService {

    User findById(int id);

    User findBySSO(String sso);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserBySSO(String sso);

    List<User> findAllUsers();

    boolean isUserSSOUnique(Integer id, String sso);

}
