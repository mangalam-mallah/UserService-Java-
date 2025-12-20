package com.example.userservice.consumer;

import com.example.userservice.entities.UserInfoDto;
import com.example.userservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/v1/getUser/{userId}")
    public ResponseEntity<UserInfoDto> getUser(@PathVariable String userId){
        try {
            return ResponseEntity.ok(userService.getUserById(userId));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users/v1/createUpdate")
    public ResponseEntity<UserInfoDto> createUpdateUser(@RequestBody  UserInfoDto userInfoDto){
        try{
            UserInfoDto user = userService.createOrUpdateUser(userInfoDto);
            return new ResponseEntity<>(user,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
