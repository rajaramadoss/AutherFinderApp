package com.autherfinder.userprofile.service;

import com.autherfinder.userprofile.exception.ResourceAlreadyExistsException;
import com.autherfinder.userprofile.exception.ResourceNotFoundException;
import com.autherfinder.userprofile.model.UserProfile;
import com.autherfinder.userprofile.repository.UserProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService{

    @Autowired
    UserProfileRepo userProfileRepo;

    @Override
    public List<UserProfile> getAllUsers() {
        List<UserProfile> findallProfile= userProfileRepo.findAll();
        return findallProfile;
    }

    @Override
    public UserProfile getUserProfileById(String username) {
        System.out.println("getUserProfileById:: ========== :: "+username);
        UserProfile userProfile=userProfileRepo.findById(username).orElseThrow(() ->
                new ResourceNotFoundException("Entity not found with userProfile ID: " + username));
        return userProfile;
    }

    @Override
    public UserProfile saveUserProfile(UserProfile userProfile) {
        System.out.println(":: =saveUserProfile method :: ==");
       if (userProfileRepo.existsById(userProfile.getUsername())){//userProfile.getUserProfileID()
           throw new ResourceAlreadyExistsException("Username Already exists");
       }
        if (userProfileRepo.existsByEmail(userProfile.getEmail())) {
            throw new ResourceAlreadyExistsException("Email Already exists");
        }

        UserProfile userProfile1 =userProfileRepo.save(userProfile);
        System.out.println(":: =saveUserProfile method :: == End "+userProfile1);
        return userProfile1 ;
    }

    @Override
    public UserProfile updateUserProfile(UserProfile userProfiles, String  username) {
        UserProfile userProfile = userProfileRepo.findById(username)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Entity not found with ID: " + username)
                );
        userProfile.setFirstName(userProfiles.getFirstName());
        userProfile.setLastName(userProfiles.getLastName());

        userProfileRepo.save(userProfile);
        return userProfile;
    }

  /*  @Override
    public boolean existsByEmail(String email) {

        if (userProfileRepo.existsByEmail(email)) {
            throw new ResourceAlreadyExistsException("Email Already exists");
        }
        return true;
    }*/
}
