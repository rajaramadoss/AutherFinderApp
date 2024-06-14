package com.casestudy.wishlist.repository;

import com.casestudy.wishlist.model.Auther;
import com.casestudy.wishlist.model.Wishlist;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepo extends MongoRepository<Wishlist,String> { //JpaRepository

    public List<Wishlist> findByUsername(String username);

}
