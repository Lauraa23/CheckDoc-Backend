package com.checkdoc.checkdoc_back.service.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.checkdoc.checkdoc_back.repository.AppointmentRepository;
import com.checkdoc.checkdoc_back.model.AppointmentModel;

@Service
public class GetAppointmentsByUser {
    
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<AppointmentModel> getAppoitmentsByUserId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }
}
