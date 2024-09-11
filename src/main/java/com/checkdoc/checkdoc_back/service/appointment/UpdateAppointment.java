package com.checkdoc.checkdoc_back.service.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import com.checkdoc.checkdoc_back.model.AppointmentModel;
import com.checkdoc.checkdoc_back.repository.AppointmentRepository;

@Service
public class UpdateAppointment {
    
    @Autowired
    private AppointmentRepository appointmentRepository;

    public void updateDateAppointment(Long appointmentId, LocalDateTime newAppointmentDate) {
        AppointmentModel appointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setAppointmentDate(newAppointmentDate);
        appointmentRepository.save(appointment);
    }
}
