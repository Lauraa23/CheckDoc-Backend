package com.checkdoc.checkdoc_back.service.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.checkdoc.checkdoc_back.model.AppointmentModel;
import com.checkdoc.checkdoc_back.repository.AppointmentRepository;

@Service
public class GetAppointmentByDoctorId {
    
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<AppointmentModel> getAppointmentByDoctorId(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }
}
