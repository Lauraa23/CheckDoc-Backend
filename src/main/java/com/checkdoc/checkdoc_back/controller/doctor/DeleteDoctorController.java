package com.checkdoc.checkdoc_back.controller.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.checkdoc.checkdoc_back.service.doctor.DeleteDoctor;

@RestController
public class DeleteDoctorController {

    @Autowired
    private DeleteDoctor deleteDoctor;

    @DeleteMapping("/doctor/deleteDoctorById")
    public ResponseEntity<String> deleteDoctor(@RequestParam("id") Long id) {
        try {
            deleteDoctor.deleteDoctorById(id);
            return ResponseEntity.ok("Doctor removed");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error removing doctor");
        }
    }
}
