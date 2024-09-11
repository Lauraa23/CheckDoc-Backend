package com.checkdoc.checkdoc_back.service.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkdoc.checkdoc_back.model.AppointmentModel;
import com.checkdoc.checkdoc_back.repository.AppointmentRepository;

import jakarta.transaction.Transactional;

@Service
public class CancellAppointment {
    
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Transactional
    public void cancellAppointmentById(Long appointmentId) {

        AppointmentModel appointment = appointmentRepository.findById(appointmentId)
        .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setStatus("cancelled");
        appointmentRepository.save(appointment);
    }
}
