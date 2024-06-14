
package com.autherfinder.userprofile.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class kafkaConfig {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Bean
    public NewTopic topic(){
        //Topic Name
        return TopicBuilder.name("kafkauserprofile").build();

    }
}

