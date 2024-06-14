package com.stackroute.authenticationservice.kafka;

import com.google.gson.Gson;
import com.stackroute.authenticationservice.model.UserDetails;
import com.stackroute.authenticationservice.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageConsumer {
    @Autowired
    AuthenticationRepository repository;

    @KafkaListener(topics = "kafkauserprofile", groupId = "user-group")
    public void kafkaMessageListener( String userDetails) {//UserDetails
        Gson gson = new Gson();

        UserDetails credential = gson.fromJson(userDetails,UserDetails.class);

        repository.save(credential);
        System.out.println("Message received is credential " + credential);
        System.out.println("Message received is " + userDetails);

    }

}
