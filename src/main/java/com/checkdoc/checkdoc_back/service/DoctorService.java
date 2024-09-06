package com.checkdoc.checkdoc_back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.checkdoc.checkdoc_back.model.DoctorModel;
import com.checkdoc.checkdoc_back.repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorModel> getAllDoctors() {
        return doctorRepository.findAll();
    }

}
