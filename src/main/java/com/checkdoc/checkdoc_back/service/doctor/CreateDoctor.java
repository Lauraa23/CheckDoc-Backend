package com.checkdoc.checkdoc_back.service.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.checkdoc.checkdoc_back.model.DoctorModel;
import com.checkdoc.checkdoc_back.model.UserModel;
import com.checkdoc.checkdoc_back.repository.DoctorRepository;
import com.checkdoc.checkdoc_back.repository.UserRepository;

@Service
public class CreateDoctor {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired 
    private DoctorRepository doctorRepository;

    public void saveDoctor(UserModel user, DoctorModel doctor) {

        UserModel savedUser = userRepository.save(user);

        doctor.setUser(savedUser);

        doctorRepository.save(doctor);

    }
}
