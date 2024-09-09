package com.checkdoc.checkdoc_back.service.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.checkdoc.checkdoc_back.repository.UserRepository;


@Service
public class DeleteDoctor {
    
    @Autowired
    private UserRepository userRepository;

    public void deleteDoctorById(Long id) {
        userRepository.deleteById(id);
    }
}
