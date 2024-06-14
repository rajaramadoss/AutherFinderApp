package com.casestudy.wishlist.service;

import com.casestudy.wishlist.model.Auther;
import com.casestudy.wishlist.model.Wishlist;

import java.util.List;

public interface WishListService {
    //List<Auther> getAllAuther();
    List<Wishlist> getUserWishlist(String username);
    Wishlist saveWishList(String username, Wishlist auther);//String username,
    Wishlist deleteWishlist(String username, String id);



}
