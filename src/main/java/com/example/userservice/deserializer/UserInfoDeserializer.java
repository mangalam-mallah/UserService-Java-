package com.example.userservice.deserializer;

import com.example.userservice.entities.UserInfoDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class UserInfoDeserializer implements Deserializer<UserInfoDto> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public UserInfoDto deserialize(String arg0, byte[] arg1) {
        ObjectMapper objectMapper = new ObjectMapper();
        UserInfoDto user = null;
        try{
            user = objectMapper.readValue(arg1, UserInfoDto.class);
        } catch (Exception e) {
        }
        return user;
    }


    @Override
    public void close() {
        Deserializer.super.close();
    }
}
