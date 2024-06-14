package com.stackroute.authenticationservice.service;

 import com.stackroute.authenticationservice.exception.UserAlreadyExistException;
import com.stackroute.authenticationservice.model.AuthenticationResponse;
import com.stackroute.authenticationservice.model.UserDetails;
import com.stackroute.authenticationservice.repository.AuthenticationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*import com.stackroute.authenticationservice.exception.UserAlreadyExistException;
import com.stackroute.authenticationservice.exception.UserNotFoundException;*/

/*import java.util.Optional;*/
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
     @Autowired
    AuthenticationRepository repository;
    @Autowired
    AuthenticationService authenticationService;


    @Override
    public boolean loginUser(String username, String password) {

        UserDetails userDetails = repository.findByUsername(username);

        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        log.info(password);
        log.info(userDetails.getPassword());
        //log.info(encoder.matches(password, userDetails.getPassword())+"");
        if(userDetails!=null && userDetails.getPassword().equals(password))//&& encoder.matches(password, userDetails.getPassword())
        {
            log.info(username+"--service--"+password);
            return true;
        }
            return false;
        //return false;
    }

    @Override
    public String getRoleByUserAndPass(String username, String password) {
        String r = repository.findByUsername(username).getRole();
        log.info(r+"role---");
        return r;
    }





   /* @Value("${app.service.message1}")
    private String message1;

    @Value("${app.service.message2}")
    private String message2;
*/

    /*@Override
    public UserDetails saveUserDetails(UserDetails userDetails) throws UserAlreadyExistException {//String username,
        Optional<UserDetails> userResult = repository.findById(userDetails.getUsername());
        if (userResult.isPresent()) {
            throw new UserAlreadyExistException(message1);
        }else if (userDetails.getUsername() == null || userDetails.getUsername().isEmpty()) {
            throw new UserAlreadyExistException("User Id cannot be empty");
        } else if (userDetails.getPassword() == null || userDetails.getPassword().isEmpty()) {
            throw new UserAlreadyExistException("Password cannot be empty");
        } else if (userDetails.getRole() == null) {
            throw new UserAlreadyExistException("Role cannot be empty");
        }
        return repository.save(userDetails);

        // UserDetails user  =repository.save(userDetails);
        // return userDetails ;
    }*/


   /* @Override
    public UserDetails loginUser(String username, String password) throws UserNotFoundException {
        System.out.println(" Service impl :: loginUser :: method");
        UserDetails userDetails=repository.findByIdAndPassword(username,password);
        System.out.println(" Service impl :: loginUser :: method"+userDetails);
        if (userDetails == null) {
            throw new UserNotFoundException(message2);
        }


                *//*.orElseThrow(() ->
                new ResourceNotFoundException("Entity not found with UserDetails ID: " + request));*//*

        //token generated logic if login success.

        return userDetails;
    }*/
  /*  @Override
    public UserDetails findByIdAndPassword(String username, String password) throws UserNotFoundException {
        UserDetails authUser = repository.findByIdAndPassword(username, password);
        System.out.println(" findByIdAndPassword :: Service impl ::  method");
        if (authUser == null) {
            throw new UserNotFoundException(message2);
        }
        return authUser;
    }*/

    /*@Override
    public Boolean isTokenValid(String token) {

        return authenticationService.isTokenValid(token);
    }*/

 /*   @Override
    public AuthenticationResponse loginUser(UserDetails userDetails) {
        return null;
    }*/
  /*  @Override
    public AuthenticationResponse loginUser(UserDetails request) {
        logger.info("Inside AuthenticateServiceImpl :: loginUser ======>");
        Authentication authentication = null;
        try{
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        }catch(Exception e){
            throw e;
        }
        if (authentication.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = tokenService.generateToken(request.getUsername());
            logger.info("Exiting AuthenticateServiceImpl :: loginUser ======>");
            logger.debug("Token generated : "+token);
            return new AuthenticationResponse(token,request.getUsername());
        }
        return null;
    }*/



}
