package com.casestudy.wishlist.service;

import com.casestudy.wishlist.controller.WishListController;
import com.casestudy.wishlist.exception.ResourceNotFoundException;
import com.casestudy.wishlist.model.Auther;
import com.casestudy.wishlist.model.Wishlist;
import com.casestudy.wishlist.repository.WishListRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class WishListServiceImpl implements WishListService{
    private Logger log= LoggerFactory.getLogger(WishListServiceImpl.class);
    @Autowired
    WishListRepo wishListRepo;


    @Override
    public List<Wishlist> getUserWishlist(String username) {
        List<Wishlist> usrWishList= wishListRepo.findByUsername(username) ;
                if(usrWishList!=null){
                    return  usrWishList;

                }else {
                    throw new ResourceNotFoundException("Entity not found with userProfile ID: " + username);

                }



    }

    public Wishlist saveWishList(String username, Wishlist auther) {//
        System.out.println(" User Name :"+ username +" ===" + "WishList ::"+auther.toString());
        Wishlist wl=new Wishlist();
        wl.setUsername(username);
        wl.setKey(auther.getKey());
        wl.setType(auther.getType());
        wl.setName(auther.getName());
        wl.setTop_work(auther.getTop_work());
        wl.setWork_count(auther.getWork_count());
        wl.setTop_subject(auther.getTop_subject());

        Wishlist result=null;
        if (username!=null){
              result  =wishListRepo.save(wl);
        }

        return result;
    }

    @Override
    public Wishlist deleteWishlist(String username, String id) {
        log.info("Service deleteByUsername: " + username);

        Wishlist wishlist = wishListRepo.findById(username)
                .orElseThrow(() -> new ResourceNotFoundException("Username not found"));

        return wishlist;
    }




    private void addOrUpdateTrack(Wishlist wishList, Auther auther) {
    }
}
