package com.checkdoc.checkdoc_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.checkdoc.checkdoc_back.model.AppointmentModel;

public interface AppointmentRepository extends JpaRepository<AppointmentModel, Long>{
    
    List<AppointmentModel> findByDoctorId(Long doctorId);
    List<AppointmentModel> findByPatientId(Long patientId);
}
