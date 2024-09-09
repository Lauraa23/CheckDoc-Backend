package com.checkdoc.checkdoc_back.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkdoc.checkdoc_back.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class DeleteUser {
    
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void deleteUserByEmail(String email) {
        userRepository.deleteByEmail(email);
    }
}
