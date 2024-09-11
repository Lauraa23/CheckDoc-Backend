package com.checkdoc.checkdoc_back.controller.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import com.checkdoc.checkdoc_back.service.appointment.UpdateAppointment;

@RestController
public class UpdateAppointmentController {
    
    @Autowired
    private UpdateAppointment updateAppointment;

    @PutMapping("/appointment/updateAppointment")
    public String updateDateAppointment(
        @RequestParam("appointmentId") Long appointmentId,
        @RequestParam("newAppointmentDate") LocalDateTime newAppointmentDate
    ) {
        updateAppointment.updateDateAppointment(appointmentId, newAppointmentDate);
        return "Appointment updated";
    }
}
