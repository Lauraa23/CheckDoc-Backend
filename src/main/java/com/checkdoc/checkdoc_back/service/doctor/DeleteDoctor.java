package com.checkdoc.checkdoc_back.service.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.checkdoc.checkdoc_back.repository.UserRepository;

import jakarta.transaction.Transactional;


@Service
public class DeleteDoctor {
    
    @Autowired
    private UserRepository userRepository;
  
    @Transactional
    public void deleteDoctorByEmail(String email) {
        userRepository.deleteByEmail(email);
    }
}
