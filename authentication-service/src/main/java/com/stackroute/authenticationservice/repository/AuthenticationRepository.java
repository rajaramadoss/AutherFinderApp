package com.stackroute.authenticationservice.repository;

import com.stackroute.authenticationservice.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<UserDetails,String> {
    //public UserDetails findByIdAndPassword(String username, String password);


    UserDetails findByUsername(String username);
}

