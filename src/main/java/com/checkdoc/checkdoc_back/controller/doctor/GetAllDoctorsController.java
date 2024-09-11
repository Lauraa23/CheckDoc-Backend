package com.checkdoc.checkdoc_back.controller.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.checkdoc.checkdoc_back.model.DoctorModel;
import com.checkdoc.checkdoc_back.repository.DoctorRepository;


import java.util.List;



@RestController
public class GetAllDoctorsController {
    
    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/doctor/getAll")
    public List<DoctorModel> getAllDoctors() {
       List<DoctorModel> Doctors = doctorRepository.findAll();
       return Doctors;
    }
 }
