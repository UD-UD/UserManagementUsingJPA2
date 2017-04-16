package com.jpa2.userStore.services;

import com.jpa2.userStore.model.UserProfile;

import java.util.List;

/**
 * Created by ud on 16/4/17.
 */
public interface UserProfileServices {

    UserProfile findById(int id);

    UserProfile findByType(String type);

    List<UserProfile> findAll();

}