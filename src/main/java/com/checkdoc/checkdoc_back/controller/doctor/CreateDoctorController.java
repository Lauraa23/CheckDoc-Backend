package com.checkdoc.checkdoc_back.controller.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.checkdoc.checkdoc_back.model.DoctorModel;
import com.checkdoc.checkdoc_back.model.UserModel;
import com.checkdoc.checkdoc_back.service.doctor.CreateDoctor;

@RestController
public class CreateDoctorController {
    
    @Autowired
    private CreateDoctor createDoctor; 

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/doctor/createDoctor")
    public ResponseEntity<String> createDoctor(
        @RequestParam("name") String name,
        @RequestParam("email") String email,
        @RequestParam("password") String password,
        @RequestParam("specialty") String specialty,
        @RequestParam("bio") String bio,
        @RequestParam("price") Double price) {
            try {
            String encodedPassword = passwordEncoder.encode(password);

            UserModel user = new UserModel();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(encodedPassword);
            user.setRole("doctor");

            DoctorModel doctor = new DoctorModel();
            doctor.setName(name);
            doctor.setSpecialty(specialty);
            doctor.setBio(bio);
            doctor.setPrice(price);

            createDoctor.saveDoctor(user, doctor);
            
            return ResponseEntity.ok("Doctor register sucessfully");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Doctor register failed" + e.getMessage());
            }
    }

}
