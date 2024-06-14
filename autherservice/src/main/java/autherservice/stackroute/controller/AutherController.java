package autherservice.stackroute.controller;

import autherservice.stackroute.model.Auther;
import autherservice.stackroute.model.Docs;
import autherservice.stackroute.service.OpenLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;
import org.springframework.http.HttpStatus;


import java.util.Arrays;

@RestController
@RequestMapping("/api/v1.0/autherservice")
public class AutherController {
    @Autowired
    OpenLibraryService service;
    @RequestMapping(value="/viewNews",method= RequestMethod.GET,consumes= MediaType.ALL_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getdata()
    {
        Auther data=service.getData();
        System.out.println("Data :: ==>"+data);
        List<Docs> articles= Arrays.asList(data.getDocs());
        System.out.println("articles :: ==>"+articles);
        return new ResponseEntity<List<Docs>>(articles,HttpStatus.OK);

    }


    //GET DATA BY KEY
//    @GetMapping("/getAllByAuther/{name}")
//    public ResponseEntity<?> findAllByCity(@PathVariable("name") String name) {
//        return new ResponseEntity<>(service.findAllByAuther(name), HttpStatus.OK);
//    }


}
