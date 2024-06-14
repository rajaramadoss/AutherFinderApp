package com.stackroute.authenticationservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Data
@AllArgsConstructor
@NoArgsConstructor*/
public class AuthAccessToken {
    private String message;
    @JsonProperty("jwt_token")
    private String jwtToken;
    private String role;
    private String username;
    public AuthAccessToken(){}

    public AuthAccessToken(String message, String jwtToken, String role, String username) {
        this.message = message;
        this.jwtToken = jwtToken;
        this.role = role;
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
