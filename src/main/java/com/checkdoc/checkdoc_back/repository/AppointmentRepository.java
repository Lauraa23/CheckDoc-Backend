package com.checkdoc.checkdoc_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.checkdoc.checkdoc_back.model.AppointmentModel;

public interface AppointmentRepository extends JpaRepository<AppointmentModel, Long>{
    
}
