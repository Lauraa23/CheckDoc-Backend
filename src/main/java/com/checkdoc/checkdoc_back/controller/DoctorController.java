package com.checkdoc.checkdoc_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.checkdoc.checkdoc_back.model.DoctorModel;
import com.checkdoc.checkdoc_back.service.DoctorService;

import java.util.List;



@RestController
public class DoctorController {
    
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctors")
    public List<DoctorModel> getAllDoctors() {
        return doctorService.getAllDoctors();
    }
    


 }
