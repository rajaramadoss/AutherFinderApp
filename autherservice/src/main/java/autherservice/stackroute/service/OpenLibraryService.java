package autherservice.stackroute.service;

import autherservice.stackroute.model.Auther;
import autherservice.stackroute.model.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Service
public class OpenLibraryService {

//    @Autowired
//    AutherRepo repo;

    public Auther getData(){
        RestTemplate resttemp=new RestTemplate();

        String url="https://openlibrary.org/search/authors.json?q=twain";
        System.out.println("url :: ==>"+url);
        Auther result=resttemp.getForObject(url, Auther.class);
        System.out.println("result :: ==>"+result);
        return result;


    }
     // List<Wishlist> findAllByAuther(String authername);
//    public List<Wishlist> findAllByAuther(String authername) {
//        List<Wishlist> getAllAutherByName=repo.findAllByAuther(authername);
//        return getAllAutherByName;
//    }

}

