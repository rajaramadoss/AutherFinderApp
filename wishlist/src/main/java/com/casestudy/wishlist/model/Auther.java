package com.casestudy.wishlist.model;

import com.fasterxml.jackson.annotation.JsonProperty;
/*import jakarta.persistence.*;*/

import java.util.List;


/*@Table(name="Auther")*/
//@Entity
public class Auther {

  /*  @Id
    private String userName;*/

    @JsonProperty("numFound")
           // @Id
   int numFound;
    @JsonProperty("start")
   int start;

    //Docs[] docs;
   /* @JsonProperty("docs")
    @JoinColumn(name = "numFound", referencedColumnName = "numFound")
    @OneToMany(targetEntity=Docs.class,cascade = CascadeType.ALL)*/
      List<Docs> docs;
  /*  public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
*/
    public int getNumFound() {
        return numFound;
    }

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<Docs> getDocs() {
        return docs;
    }

    public void setDocs(List<Docs> docs) {
        this.docs = docs;
    }
}
