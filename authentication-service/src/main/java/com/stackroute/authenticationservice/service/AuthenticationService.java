package com.stackroute.authenticationservice.service;

/*import com.stackroute.authenticationservice.exception.UserNotFoundException;
import com.stackroute.authenticationservice.model.UserDetails;
import com.stackroute.authenticationservice.exception.UserAlreadyExistException;

import com.stackroute.authenticationservice.model.AuthenticationResponse;

import org.springframework.stereotype.Service;*/


public interface AuthenticationService {



    public boolean loginUser(String username, String password);// login


    public String getRoleByUserAndPass(String username, String password);






    //UserDetails  saveUserDetails( UserDetails userDetails) throws UserAlreadyExistException;

   // public UserDetails findByIdAndPassword(String username, String password) throws UserNotFoundException;


    //public Boolean isTokenValid(String token);
    //public UserDetails loginUser(String username, String password) throws UserNotFoundException;


   // public AuthenticationResponse loginUser(UserDetails userDetails);


}
