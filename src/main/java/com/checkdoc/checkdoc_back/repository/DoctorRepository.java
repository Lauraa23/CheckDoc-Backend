package com.checkdoc.checkdoc_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.checkdoc.checkdoc_back.model.DoctorModel;

public interface DoctorRepository extends JpaRepository<DoctorModel, Long>{
    
}
