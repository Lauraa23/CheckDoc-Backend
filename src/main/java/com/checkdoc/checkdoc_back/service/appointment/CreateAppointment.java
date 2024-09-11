package com.checkdoc.checkdoc_back.service.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import com.checkdoc.checkdoc_back.model.AppointmentModel;
import com.checkdoc.checkdoc_back.model.DoctorModel;
import com.checkdoc.checkdoc_back.model.UserModel;
import com.checkdoc.checkdoc_back.repository.AppointmentRepository;
import com.checkdoc.checkdoc_back.repository.DoctorRepository;
import com.checkdoc.checkdoc_back.repository.UserRepository;


@Service
public class CreateAppointment {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    public void createAppointment(Long doctorId, Long patientId, LocalDateTime appointmentDate) {

        UserModel patient = userRepository.findById(patientId)
        .orElseThrow(() -> new RuntimeException("Patient not found"));

        DoctorModel doctor = doctorRepository.findById(doctorId)
        .orElseThrow(() -> new RuntimeException("Doctor not found"));

        AppointmentModel appointmentModel = new AppointmentModel();
        appointmentModel.setPatient(patient);
        appointmentModel.setDoctor(doctor);
        appointmentModel.setAppointmentDate(appointmentDate);
        appointmentModel.setStatus("scheduled");

        appointmentRepository.save(appointmentModel);

    }

}
