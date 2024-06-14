package com.autherfinder.userprofile.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;


/*@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter*/
@Entity
@Table(name="userprofile")
public class UserProfile {
    //@Id
    //private Integer userProfileID;
    @Id
    private String username;
    private String firstName;
    private String lastName;
    @NotNull
    private String password;

    @NotNull
    private String email;
    private String gender;

    public UserProfile(){}
    public UserProfile(String username, String firstName, String lastName, String password, String email, String gender) {
        //this.userProfileID=userProfileID;    //Integer userProfileID,
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;

        this.email = email;
        this.gender = gender;
    }

//    public int getUserProfileID() {
//        return userProfileID;
//    }
//
//    public void setUserProfileID(int userProfileID) {
//        this.userProfileID = userProfileID;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
