package com.jpa2.userStore.convertor;

/**
 * Created by ud on 16/4/17.
 */

import com.jpa2.userStore.model.UserProfile;
import com.jpa2.userStore.services.UserProfileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class RoleToUserProfileConvertor implements Converter<Object, UserProfile> {

    @Autowired
    UserProfileServices userProfileService;

    public UserProfile convert(Object element) {
        Integer id = Integer.parseInt((String) element);
        UserProfile profile = userProfileService.findById(id);
        System.out.println("Profile : " + profile);
        return profile;
    }

}
