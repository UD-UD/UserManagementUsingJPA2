package com.jpa2.userStore.services;

import com.jpa2.userStore.dao.UserProfileDao;
import com.jpa2.userStore.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ud on 16/4/17.
 */
@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileServices{

    @Autowired
    UserProfileDao dao;

    public UserProfile findById(int id) {
        return dao.findById(id);
    }

    public UserProfile findByType(String type){
        return dao.findByType(type);
    }

    public List<UserProfile> findAll() {
        return dao.findAll();
    }
}