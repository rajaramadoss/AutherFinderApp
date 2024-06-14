package com.autherfinder.userprofile.service;

import com.autherfinder.userprofile.model.UserProfile;

import java.util.List;

public interface UserProfileService {
    List<UserProfile> getAllUsers();

    UserProfile getUserProfileById(String  username);

    UserProfile saveUserProfile(UserProfile userProfile);

    UserProfile updateUserProfile(UserProfile userProfile, String  username);
    //boolean existsByEmail(String email);

}
