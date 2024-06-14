package com.casestudy.wishlist.model;
import com.fasterxml.jackson.annotation.JsonProperty;
/*import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;*/

import java.util.List;


//@Table(name="wishlist")
//@Entity

public class Docs {
    @JsonProperty("key")
    //@Id
      String key;
    @JsonProperty("type")
      String type;
    @JsonProperty("name")
      String name;
    @JsonProperty("top_work")
      String top_work;
    @JsonProperty("work_count")
      int work_count;
    @JsonProperty("top_subject")
      List<String> topSubject;

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

    public List<String> getTopSubject() {
        return topSubject;
    }

    public void setTopSubject(List<String> topSubject) {
        this.topSubject = topSubject;
    }
}
