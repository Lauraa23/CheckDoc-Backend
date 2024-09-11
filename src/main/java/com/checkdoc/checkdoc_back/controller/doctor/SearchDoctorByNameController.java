package com.checkdoc.checkdoc_back.controller.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.checkdoc.checkdoc_back.model.DoctorModel;
import com.checkdoc.checkdoc_back.service.doctor.SearchDoctor;

@RestController
public class SearchDoctorByNameController {

    @Autowired
    private SearchDoctor searchDoctor;
    
    @GetMapping("/doctor/searchDoctorByName")
    public DoctorModel searchDoctorByName(@RequestParam("name") String name) {
      return searchDoctor.searchDoctorByName(name);
    }
}
