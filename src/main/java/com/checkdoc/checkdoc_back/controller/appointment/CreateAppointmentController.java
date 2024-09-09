// package com.checkdoc.checkdoc_back.controller.appointment;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import com.checkdoc.checkdoc_back.model.AppointmentModel;
// import com.checkdoc.checkdoc_back.model.DoctorModel;
// import com.checkdoc.checkdoc_back.model.UserModel;
// import com.checkdoc.checkdoc_back.repository.DoctorRepository;
// import com.checkdoc.checkdoc_back.repository.UserRepository;
// import com.checkdoc.checkdoc_back.service.appointment.CreateAppointment;

// @RestController
// public class CreateAppointmentController {
    
//     @Autowired
//     private CreateAppointment createAppointment;

//     @Autowired
//     private DoctorRepository doctorRepository;

//     @Autowired
//     private UserRepository userRepository;

//     @PostMapping("/appointment/create")
//     public String createAppointment(@RequestParam Long doctorId, @RequestParam Long patientId, @RequestBody AppointmentModel appointment) {
//         DoctorModel doctor = doctorRepository.findById(doctorId)
//     }
// }
