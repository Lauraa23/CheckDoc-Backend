package com.checkdoc.checkdoc_back.controller.doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.checkdoc.checkdoc_back.model.DoctorModel;
import com.checkdoc.checkdoc_back.service.doctor.SearchDoctor;

@RestController
public class SearchDoctorBySpecialtyController {
    
    @Autowired
    private SearchDoctor searchDoctor;

    @GetMapping("/doctor/searchDoctorBySpecialty")
    public List<DoctorModel> searchDoctorBySpecialty(@RequestParam("specialty") String specialty) {
      return searchDoctor.searchDoctorBySpecialty(specialty);
    }
}
