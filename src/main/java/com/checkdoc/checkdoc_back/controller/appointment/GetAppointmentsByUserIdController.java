package com.checkdoc.checkdoc_back.controller.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.checkdoc.checkdoc_back.service.appointment.GetAppointmentsByUser;
import com.checkdoc.checkdoc_back.model.AppointmentModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class GetAppointmentsByUserIdController {
    
    @Autowired
    private GetAppointmentsByUser getAppointmentsByUser;

    @GetMapping("/appointment/getAppoinmentByUser")
    public List<AppointmentModel> getPatientAppointments(@RequestParam("patientId") Long patientId) {
        
        return getAppointmentsByUser.getAppoitmentsByUserId(patientId);
    }
    
}
