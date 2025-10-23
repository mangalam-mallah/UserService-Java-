package com.example.userservice.consumer;

import com.example.userservice.entities.UserInfoDto;
import com.example.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceConsumer {

    @Autowired
    private UserService userService;


    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(UserInfoDto eventData){
        try{
            userService.createOrUpdateUser(eventData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
