package com.checkdoc.checkdoc_back.controller.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.checkdoc.checkdoc_back.model.DoctorModel;
import com.checkdoc.checkdoc_back.model.DoctorRequest;
import com.checkdoc.checkdoc_back.model.UserModel;
import com.checkdoc.checkdoc_back.service.doctor.CreateDoctor;

@RestController
public class CreateDoctorController {
    
    @Autowired
    private CreateDoctor createDoctor; 

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/doctor/createDoctor")
    public ResponseEntity<String> createDoctor(@RequestBody DoctorRequest doctorRequest) {
            try {
            String encodedPassword = passwordEncoder.encode(doctorRequest.getPassword());

            UserModel user = new UserModel();
            user.setName(doctorRequest.getName());
            user.setEmail(doctorRequest.getEmail());
            user.setPassword(encodedPassword);
            user.setRole("doctor");

            DoctorModel doctor = new DoctorModel();
            doctor.setName(doctorRequest.getName());
            doctor.setSpecialty(doctorRequest.getSpecialty());
            doctor.setBio(doctorRequest.getBio() != null ? doctorRequest.getBio() : "");
            doctor.setPrice(doctorRequest.getPrice());

            createDoctor.saveDoctor(user, doctor);
            
            return ResponseEntity.ok("Doctor register sucessfully");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Doctor register failed " + e.getMessage());
            }
    }

}
