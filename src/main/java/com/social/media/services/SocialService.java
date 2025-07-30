package com.social.media.services;

import com.social.media.models.Users;
import com.social.media.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {

    @Autowired
    UserRepository socialUserRepository;
    public List<Users> getAllUsers() {
        return socialUserRepository.findAll();
    }


    public List<Users> saveUsers(Users users) {
        return socialUserRepository.saveAll(List.of(users));
    }
}
