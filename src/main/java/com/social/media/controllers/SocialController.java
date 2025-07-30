package com.social.media.controllers;

import com.social.media.models.Users;
import com.social.media.services.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SocialController {
    @Autowired
    private SocialService socialService;


    @GetMapping("/social/users")
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(socialService.getAllUsers());
    }

    @PostMapping("/social/users")
    public ResponseEntity<List<Users>> saveUsers(@RequestBody Users users) {
        return ResponseEntity.ok(socialService.saveUsers(users));
    }
}
