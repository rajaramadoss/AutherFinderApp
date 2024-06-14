package  com.autherfinder.userprofile.kafka;

import com.autherfinder.userprofile.model.UserDetails;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DataPublisherServiceImpl {

    @Autowired
    private   KafkaTemplate<String,String > kafkaTemplate;//UserDetails
    private Logger logger= LoggerFactory.getLogger(DataPublisherServiceImpl.class);

   /* @Autowired
    public DataPublisherServiceImpl(KafkaTemplate<String, UserDetails> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }*/

    public void sendMessage(UserDetails user)//
    {
        Gson gson = new Gson();
        logger.info(user.toString());

        kafkaTemplate.send("kafkauserprofile", gson.toJson(user));//
    }

}
