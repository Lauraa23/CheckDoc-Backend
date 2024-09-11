package com.checkdoc.checkdoc_back.controller.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.checkdoc.checkdoc_back.model.AppointmentModel;
import com.checkdoc.checkdoc_back.service.appointment.GetAppointmentByDoctorId;

@RestController
public class GetAllAppointmentByDoctorIdController {
    
    @Autowired
    private GetAppointmentByDoctorId getAppointmentByDoctorId;

    @GetMapping("/appointment/getAppointmentsByDoctorId")
    public List<AppointmentModel> getAppointmentByDoctorId(@RequestParam("doctorId") Long doctorId) {
        return getAppointmentByDoctorId.getAppointmentByDoctorId(doctorId);
    }
}
