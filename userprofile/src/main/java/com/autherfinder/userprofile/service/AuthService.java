package com.autherfinder.userprofile.service;


import com.autherfinder.userprofile.exception.ServerConnectionException;
import com.autherfinder.userprofile.exception.UnAuthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.autherfinder.userprofile.feignclient.AuthenticationClient;

import java.net.ConnectException;
import java.util.Map;


@Component
@Slf4j
public class AuthService {
    private static final Logger log = LoggerFactory.getLogger(AuthService.class);
    @Autowired
    AuthenticationClient authenticationClient;

    public Map<String, String> validateToken(String token) {

        try {
            ResponseEntity<Map<String, String>> response = authenticationClient.validateToken(token);

            log.info(response.getBody()+"from*********");
            log.info(response.getBody()+"from*********");
            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
                throw new UnAuthorizedException("Failed to validate token: " + response.getStatusCode());
            }
        } catch (Exception e) {
            throw new ServerConnectionException("connection refused: " + e.getMessage());
        }
    }

}