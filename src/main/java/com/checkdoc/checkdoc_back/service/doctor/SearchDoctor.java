package com.checkdoc.checkdoc_back.service.doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkdoc.checkdoc_back.model.DoctorModel;
import com.checkdoc.checkdoc_back.model.LoginResponseDTO;
import com.checkdoc.checkdoc_back.repository.DoctorRepository;

@Service
public class SearchDoctor {
   
    @Autowired
    private DoctorRepository doctorRepository;

    public DoctorModel searchDoctorByName(String name) {
        return doctorRepository.findByName(name);
    }

    public List<DoctorModel> searchDoctorBySpecialty(String specialty) {
        return doctorRepository.findBySpecialty(specialty);
    }

    public LoginResponseDTO parseDoctorResponse(String email, String jwt) {
        DoctorModel doctor = doctorRepository.findByUserEmail(email)
        .orElseThrow(() -> new RuntimeException("Doctor not found"));
        LoginResponseDTO response = new LoginResponseDTO(doctor.getId(), doctor.getUser().getEmail(), doctor.getName(), jwt);
        return response;
    }
}
