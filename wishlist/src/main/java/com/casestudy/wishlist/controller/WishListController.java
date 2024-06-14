package com.casestudy.wishlist.controller;

import com.casestudy.wishlist.exception.UnAuthorizedException;
import com.casestudy.wishlist.model.Auther;
import com.casestudy.wishlist.model.Wishlist;
import com.casestudy.wishlist.service.AuthService;
import com.casestudy.wishlist.service.WishListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/v1.0/wishList")
@Slf4j
public class WishListController {
    private Logger log= LoggerFactory.getLogger(WishListController.class);
    @Autowired
    WishListService wishListService;
    @Autowired
    AuthService authService;


    @PostMapping("/addWishlist/{username}")
    public ResponseEntity<?> saveWishList(@RequestHeader("Authorization") String token, @PathVariable String username,@RequestBody Wishlist wishlist){
        log.trace("Controller saveTrackToWishList: "+username);
        Map<String,String> info= authService.validateToken(token);
        log.info(info.toString()+"    <=------inside method saveTrackToWishList-----");
        if(info.containsKey(username)) {
            log.error(token + "inside method get all-----__---");
            return new ResponseEntity<>(wishListService.saveWishList(username,wishlist),HttpStatus.CREATED);
        }
        throw new UnAuthorizedException("Please  check User Id: "+username);


    }

   // @GetMapping("/getWishListByName/{name}")
   @SecurityRequirement(name = "Bearer Authentication")
   @Operation(summary = "Get Users WishList Details")
   @ApiResponses(value = {
           @ApiResponse(responseCode = "200", description = "WishList Details Found",
                   content = { @Content(mediaType = "application/json",
                           schema = @Schema(implementation = Wishlist.class)) }),
           @ApiResponse(responseCode = "404", description = "WishList not found",
                   content = @Content),
           @ApiResponse(responseCode = "401", description = "Unauthorized user",
                   content = @Content) })
    @GetMapping("/userWishList/{username}")
    public ResponseEntity<?> getUserWishlist(@RequestHeader("Authorization") String token,@PathVariable String username) {

        return new ResponseEntity<>(wishListService.getUserWishlist(username), HttpStatus.OK);
    }

//     if (jwtService.isTokenValid(token,username)){
//        return new ResponseEntity<>(wishlistService.getWishlists(username), HttpStatus.OK);
//    }
//        throw new UnAuthorizedException("Unauthorized token access Wishlist");
//}


    @Operation(summary = "Delete Movie from Favorite List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Bill Board 100 Playlist",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Wishlist.class)) }),
            @ApiResponse(responseCode = "404", description = "Movie not delete",
                    content = @Content) })
    @SecurityRequirement(name = "Bearer Authentication")
    @DeleteMapping("")
    public ResponseEntity<Object> deleteWishlist(@Parameter(hidden = true) @RequestHeader("Authorization") String token, @RequestParam String username, @RequestParam String id){
        log.trace("Controller saveTrackToWishList: "+username);
        Map<String,String> info= authService.validateToken(token);
        log.info(info+"------inside method saveTrackToWishList-----");
        if(info.containsKey(username) && info.containsKey(id)) {
            log.error(token + "inside method get all-----__---");
            return new ResponseEntity<>(wishListService.deleteWishlist(username,id),HttpStatus.CREATED);
        }
        throw new UnAuthorizedException("Please  check User Id: "+username);

    }

}
