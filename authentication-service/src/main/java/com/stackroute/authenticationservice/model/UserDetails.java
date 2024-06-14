package com.stackroute.authenticationservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="userdetails")
public class UserDetails {
    @Id
    private  String username;
    private String password;
    private  String role;

    public UserDetails(){}

    public UserDetails(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "username='" + username +
                ", password='" + password +
                ", role='" + role +
                '}';
    }
}
