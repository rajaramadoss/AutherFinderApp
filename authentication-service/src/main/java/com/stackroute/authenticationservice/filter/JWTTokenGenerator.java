package com.stackroute.authenticationservice.filter;

import com.stackroute.authenticationservice.model.UserDetails;

import java.util.Map;

public interface JWTTokenGenerator {
    Map<String, String> generateToken(UserDetails userDetails);
}
