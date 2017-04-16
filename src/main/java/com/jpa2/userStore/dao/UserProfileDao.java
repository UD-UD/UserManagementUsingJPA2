package com.jpa2.userStore.dao;

import com.jpa2.userStore.model.UserProfile;

import java.util.List;

/**
 * Created by ud on 16/4/17.
 */
public interface UserProfileDao {

    List<UserProfile> findAll();

    UserProfile findByType(String type);

    UserProfile findById(int id);
}
