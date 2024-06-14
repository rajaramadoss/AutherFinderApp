package com.casestudy.wishlist.model;

import java.util.ArrayList;
/*import jakarta.persistence.Entity;*/
/*import jakarta.persistence.Id;
import jakarta.persistence.Table;*/
import lombok.*;
/*import org.antlr.v4.runtime.misc.NotNull;*/
import com.fasterxml.jackson.annotation.JsonProperty;
/*import jakarta.persistence.*;*/
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


//@Entity
@Document
//@Table(name="wishlist")
public class Wishlist {
    //@JsonProperty("username")
    //@Id
    private String username;
    // @JsonProperty("numFound")
    //private Integer numFound;
    // @JsonProperty("start")
    //private Integer start;
    //// @JsonProperty("key")
    private  String key;
    // @JsonProperty("type")
    private  String type;
    // @JsonProperty("name")
    private String name;
    //@JsonProperty("top_work")
    private String top_work;
    //@JsonProperty("work_count")
    private Integer work_count;

    private  String top_subject;


    public Wishlist(String username,    String key, String type, String name, String top_work, int work_count, String  top_subject) {
        this.username = username;


        this.key = key;
        this.type = type;
        this.name = name;
        this.top_work = top_work;
        this.work_count = work_count;
        this.top_subject = top_subject;
    }
    public Wishlist(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }





    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTop_work() {
        return top_work;
    }

    public void setTop_work(String top_work) {
        this.top_work = top_work;
    }

    public int getWork_count() {
        return work_count;
    }

    public void setWork_count(int work_count) {
        this.work_count = work_count;
    }

    public String getTop_subject() {
        return top_subject;
    }

    public void setTop_subject( String top_subject) {
        this.top_subject = top_subject;
    }
}
