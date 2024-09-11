package com.checkdoc.checkdoc_back.controller.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.checkdoc.checkdoc_back.service.appointment.CancellAppointment;


@RestController
public class CancellAppointmentController {
    
    @Autowired
    private CancellAppointment cancellAppointment;

    @PutMapping("/appointment/cancellAppointment")
    public ResponseEntity<String> cancellAppointment(@RequestParam("appointmentId") Long id) {
       
        try {
            cancellAppointment.cancellAppointmentById(id);
            return ResponseEntity.ok().body("Appointment cancelled");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad parameters");
        }
        
    }
}
