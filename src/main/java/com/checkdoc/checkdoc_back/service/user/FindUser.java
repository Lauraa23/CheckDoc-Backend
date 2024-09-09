package com.checkdoc.checkdoc_back.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.checkdoc.checkdoc_back.model.UserModel;
import com.checkdoc.checkdoc_back.repository.DoctorRepository;
import com.checkdoc.checkdoc_back.repository.UserRepository;

@Service
public class FindUser {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public UserModel login(String email, String password) {
        UserModel user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password) && user.getRole().equals("doctor")) {
            doctorRepository.findByUser(user);
            return user;
        } 
        throw new RuntimeException("Invalid credentials");
    }
}
