package com.example.postgresdemo.controller;

import com.example.postgresdemo.google.GoogleAuthenticator;
import com.example.postgresdemo.model.Pet;
import com.example.postgresdemo.model.User;
import com.example.postgresdemo.repository.UserRepository;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.util.Collections;

@RestController
public class UserController {
    private UserRepository userRepository;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/user/{token}")
    public ResponseEntity<User> createUser(@PathVariable String token) throws GeneralSecurityException, IOException {
        User user = new User();
        GoogleAuthenticator auth = new GoogleAuthenticator(token);
        GoogleIdToken.Payload payload = auth.getPayload();
        if (payload != null)
        {
            user.setId(payload.getSubject());
            user.setEmail(payload.getEmail());
            user.setName((String)payload.get("name"));
            user.setPicUrl((String)payload.get("picture"));
            user.setLastVisit(LocalDateTime.now());
        }
        if(!userRepository.existsById(user.getId()))
            userRepository.save(user);
        else
            return new ResponseEntity<User>(user,HttpStatus.CONFLICT);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
}
