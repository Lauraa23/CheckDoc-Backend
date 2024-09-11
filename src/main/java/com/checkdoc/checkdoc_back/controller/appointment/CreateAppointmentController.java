package com.checkdoc.checkdoc_back.controller.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.checkdoc.checkdoc_back.model.CreateAppointmentRequest;
import com.checkdoc.checkdoc_back.service.appointment.CreateAppointment;

@RestController
public class CreateAppointmentController {

    @Autowired
    private CreateAppointment createAppointment;
    
    @PostMapping("/appointment/create")
    public ResponseEntity<?> createAppointment(@RequestBody CreateAppointmentRequest request) {
        createAppointment.createAppointment(request.getDoctorId(), request.getPatientId(), request.getAppointmentDate());
        return ResponseEntity.ok("Appointment created");
    }
}
