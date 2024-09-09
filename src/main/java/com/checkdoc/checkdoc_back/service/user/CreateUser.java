package com.checkdoc.checkdoc_back.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.checkdoc.checkdoc_back.model.UserModel;
import com.checkdoc.checkdoc_back.repository.UserRepository;


@Service
public class CreateUser {
    
    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserModel user) {

        userRepository.save(user);

    }
}
