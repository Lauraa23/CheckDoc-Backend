// package com.checkdoc.checkdoc_back.service.appointment;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.checkdoc.checkdoc_back.model.AppointmentModel;
// import com.checkdoc.checkdoc_back.model.DoctorModel;
// import com.checkdoc.checkdoc_back.model.UserModel;
// import com.checkdoc.checkdoc_back.repository.AppointmentRepository;
// import com.checkdoc.checkdoc_back.repository.DoctorRepository;
// import com.checkdoc.checkdoc_back.repository.UserRepository;

// @Service
// public class CreateAppointment {

//     @Autowired
//     private AppointmentRepository appointmentRepository;

//     @Autowired
//     private DoctorRepository doctorRepository;

//     @Autowired
//     private UserRepository userRepository;

//     public void saveAppointment(UserModel patient, DoctorModel doctor, AppointmentModel appointment) {

//         DoctorModel doctor = doctorRepository.findById(doctorId);
//         UserModel patient = userRepository.findById(patientId);

//         appointment.setDoctor(doctor);
//         appointment.setPatient(patient);
//         appointmentRepository.save(appointment);


//     }
// }
