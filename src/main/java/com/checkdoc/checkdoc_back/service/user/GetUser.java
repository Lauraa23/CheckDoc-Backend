package com.checkdoc.checkdoc_back.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.checkdoc.checkdoc_back.model.UserModel;
import com.checkdoc.checkdoc_back.repository.UserRepository;

@Service
public class GetUser {
    
    @Autowired
    private UserRepository userRepository;

    public UserModel getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
