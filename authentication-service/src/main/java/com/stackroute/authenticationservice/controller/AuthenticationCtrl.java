package com.stackroute.authenticationservice.controller;

import com.stackroute.authenticationservice.exception.CustomUnAuthorizedException;
import com.stackroute.authenticationservice.filter.JwtUtils;
import com.stackroute.authenticationservice.model.AuthAccessToken;
import com.stackroute.authenticationservice.model.UserDetails;
import com.stackroute.authenticationservice.service.AuthenticationService;
import com.stackroute.authenticationservice.filter.JWTTokenGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.ServletException;

import org.springframework.http.HttpStatus;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class AuthenticationCtrl {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationCtrl.class);
    @Autowired
    AuthenticationService service;
    @Autowired
    private JWTTokenGenerator jwtTokenGenerator;


    @Value("${secret.key}")
    String secret;


    //private final AuthenticationService service;

    @Autowired
    private  JwtUtils jwtUtils;


    @Autowired
    public AuthenticationCtrl(AuthenticationService service, JwtUtils jwtUtils) {
        this.service = service;
        this.jwtUtils = jwtUtils;
    }

    public String generateToken(String username, String password) throws ServletException
    {
        String jwtToken;

        if(username==null || password == null)
        {
            throw new ServletException("Please enter valid username and password");
        }

        boolean flag= service.loginUser(username, password);
        String role=service.getRoleByUserAndPass(username,password);
        log.info(role+"--from dbb-- inside token"+username);

        if(!flag)
        {
            throw new ServletException("Invalid credentials");

        }
        else
        {
            log.info(role+"--last---");

            jwtToken=Jwts.builder().setSubject(username).claim("role",role)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .signWith(SignatureAlgorithm.HS256,secret).compact();

        }

        log.info(role+"--last---");
        log.info(jwtToken+"------token");
        return jwtToken;
    }

    @SecurityRequirement(name = "Bearer Authentication")//01-05-24
    @Operation(summary = "Generate Token")
    @PostMapping("/login")
    public ResponseEntity<AuthAccessToken> performLogin(@RequestBody UserDetails userProfile)
    {
        String username = userProfile.getUsername();
        String password = userProfile.getPassword();
        AuthAccessToken authAccessToken = new AuthAccessToken();
        log.info(username+"----");
        boolean check=service.loginUser(username,password);
        log.info(check+"");
        if(check){
            String role=service.getRoleByUserAndPass(username, password);
            log.info(role);
            try
            {
                log.info(generateToken(username, password));
                String jwtToken = generateToken(username, password);
                log.info(password);
                log.info(jwtToken+" inside login");
                if(role.equalsIgnoreCase("admin"))
                {

                    authAccessToken.setMessage("Admin successfully logged in");
                    log.info(jwtToken);
                    authAccessToken.setJwtToken(jwtToken);
                    authAccessToken.setRole(role);
                    authAccessToken.setUsername(username);
                    return new ResponseEntity<>(authAccessToken, HttpStatus.CREATED);

                }
                else if(role.equalsIgnoreCase("User"))
                {
                    authAccessToken.setMessage("User successfully logged in");
                    authAccessToken.setJwtToken(jwtToken);
                    authAccessToken.setRole(role);
                    authAccessToken.setUsername(username);
                    return new ResponseEntity<>(authAccessToken, HttpStatus.CREATED);
                }

            }

            catch( ServletException e)
            {
                log.info(e+"exception");
                authAccessToken.setMessage("Failed to logged in");
                authAccessToken.setJwtToken(null);
                authAccessToken.setRole(null);
            }

        }
        throw new CustomUnAuthorizedException("UnAuthorized User");

    }

    @Operation(summary = "Validate User")
    @PostMapping("/validate")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Object> validateToken(@RequestHeader("Authorization") String token) {
        log.info(token+"---------");
        if (jwtUtils.validateJwtToken(token)) {
            log.info("-------validate-------");
            Map<String, String> userInfo = new HashMap<>();
            String authToken = token.substring(7);
            String username = jwtUtils.getUserNameFromJwtToken(authToken);
            String role = jwtUtils.getRoleFromToken(authToken);
            userInfo.put(username, role);
            log.info(userInfo.toString());
            return ResponseEntity.status(HttpStatus.OK).body(userInfo);
        } else {
            log.info("-------***********-------");
            throw new CustomUnAuthorizedException("Invalid Token");
        }
    }


























    //ResponseEntity<?> responseEntity;
  /*  @Autowired
    AuthenticationResponse authenticationResponse; //token,username
*/

/*

    @Value("${app.controller.exception.message1}")
    private String message1;

    @Value("${app.controller.exception.message2}")
    private String message2;

    @Value("${app.controller.exception.message3}")
    private String message3;



    @PostMapping("/auth/login")
    public ResponseEntity<?> authenticateUser(@RequestBody UserDetails userDetails){
        logger.info("Inside AuthenticationController :: authenticateUser ======>");
        AuthenticationResponse response = service.loginUser(userDetails);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/auth/validateToken")
    public ResponseEntity<?> validateToken(@RequestParam String token){
        logger.info("Inside AuthenticationController :: validateToken ======>");
        return ResponseEntity.ok(service.isTokenValid(token));
    }

*/





   /* @PostMapping("/user")
    public ResponseEntity<?> registerUser(@RequestBody UserDetails user) {
        try {
            UserDetails savedUser = service.saveUserDetails(user);
            responseEntity =new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (UserAlreadyExistException e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }*/
   /* @PostMapping("/login/user")
    public ResponseEntity<?> loginUser(@RequestBody UserDetails user) {
        System.out.println(" ============:: loginUser ========== Controller Class"+user);
        try {
            if (user.getUsername() == null || user.getPassword() == null) {
                throw new UserNotFoundException(message1);
            }
            UserDetails userDetails = service.findByIdAndPassword(user.getUsername(), user.getPassword());
            System.out.println(" ============:: userDetails"+userDetails);
            if (userDetails == null) {
                throw new UserNotFoundException(message2);
            }
            if (!(user.getPassword().equals(userDetails.getPassword()))) {
                throw new UserNotFoundException(message3);
            }
            *//*
             * Create ResponseEntity with token generated by calling generateToken method of JwtTokenGenerator
             *//*
            if (user.getUsername() == null || user.getPassword() == null) {
                throw new UserNotFoundException("email and password are null");
            }
            Map<String, String> mytoken= new JWTTokenGeneratorImpl().generateToken(user);
            System.out.println("Inside controller Try Class Token "+mytoken);
            return new ResponseEntity<Map>(mytoken,HttpStatus.OK);



        } catch (UserNotFoundException e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }*/






   /* @PostMapping("/auth/login")
    public ResponseEntity<?> authenticateUser(@RequestBody UserDetails request){
        logger.info("Inside AuthenticationController :: authenticateUser ======>");
        UserDetails response = service.loginUser(request.getUsername());
        return ResponseEntity.ok(response);
    }*/

   /* @PostMapping("/addUserDetails")
    public ResponseEntity<?> saveUserDetails(@RequestBody UserDetails userDetails){

        return new ResponseEntity<>(service.saveUserDetails(userDetails.getUsername(),userDetails), HttpStatus.CREATED);
    }*/

}
