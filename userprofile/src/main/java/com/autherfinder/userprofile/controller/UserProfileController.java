package com.autherfinder.userprofile.controller;

import com.autherfinder.userprofile.exception.UnAuthorizedException;
import com.autherfinder.userprofile.kafka.DataPublisherServiceImpl;
import com.autherfinder.userprofile.model.UserProfile;
import com.autherfinder.userprofile.service.AuthService;
import com.autherfinder.userprofile.service.UserProfileService;
/*import kafka.DataPublisherServiceImpl;*/
import com.google.gson.Gson;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.autherfinder.userprofile.model.UserDetails;

import java.util.Map;


@RestController
@RequestMapping("/api/v1.0/userProfile")
@Slf4j
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private AuthService  authService;
    private Logger log= LoggerFactory.getLogger(UserProfileController.class);
    @Autowired/*(required=true)*/
    private DataPublisherServiceImpl producer;

    /*@Autowired(required=true)
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    } */

    @GetMapping("/getAllUserProfile")
    public ResponseEntity<?> getAllUsersProfile() {

        return new ResponseEntity<>(userProfileService.getAllUsers(),HttpStatus.OK);
    }

    @PostMapping("/addUserProfile")
    public ResponseEntity<?> saveUserProfile(@RequestBody UserProfile userProfile){

        UserDetails userDetails=new UserDetails();
        userDetails.setUsername(userProfile.getUsername());
        userDetails.setPassword(userProfile.getPassword());
        userDetails.setRole("User");
        Gson gson = new Gson();

        /*UserDetails credential = gson.fromJson(userDetails,UserDetails.class);*/
        //kafka produce
        log.info("------"+userDetails+"--------");
        producer.sendMessage(userDetails);
        return new ResponseEntity<>(userProfileService.saveUserProfile(userProfile),HttpStatus.CREATED);
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Update Users Details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User Details Updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserProfile.class)) }),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "User Details already Exists",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized user",
                    content = @Content) })
    @PutMapping("/updateProfile/{username}")
    public ResponseEntity<?> updateUserProfile(@RequestHeader("Authorization") String token,@RequestBody UserProfile userProfile,@PathVariable("username") String username){
        log.info(token+" : token from authentication to access updateUserProfile");
        Map<String,String> info= authService.validateToken(token);
        log.info("info: "+info+"inside updateUserProfile----");
        if(info.containsKey(username)) {
            log.info(token + "inside method updateUserProfile-----__---");
            return new ResponseEntity<>(userProfileService.updateUserProfile(userProfile, username),HttpStatus.OK);
        }
        log.error(token + "inside method updateUserProfile-----__---");
        throw new UnAuthorizedException("Un Authorized Please check user the details to update.");
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Get Users Details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User Details Found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserProfile.class)) }),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized user",
                    content = @Content) })
    @GetMapping("/getUserProfileById/{username}")
    public ResponseEntity<?> getUserProfileById(@RequestHeader("Authorization") String token,@PathVariable("username") String username) {
        log.info(token+" : token from authentication to access getUserProfileById");
        Map<String,String> info= authService.validateToken(token);
        log.info("inside getUserProfileById----info: "+info);
        if(info.containsKey(username)) {
            log.info(token + "inside method getUserProfileById -----__---");
            return new ResponseEntity<>(userProfileService.getUserProfileById(username), HttpStatus.OK);
        }
        throw new UnAuthorizedException("Un Authorized Please check user the details.");

    }

}
