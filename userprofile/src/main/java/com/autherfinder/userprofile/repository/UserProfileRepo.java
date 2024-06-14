package com.autherfinder.userprofile.repository;

import com.autherfinder.userprofile.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepo extends JpaRepository<UserProfile,String> {//Integer

    boolean existsByEmail(String email);

}
