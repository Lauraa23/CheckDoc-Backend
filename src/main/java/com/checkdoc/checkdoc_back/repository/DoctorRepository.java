package com.checkdoc.checkdoc_back.repository;

import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.checkdoc.checkdoc_back.model.DoctorModel;
import com.checkdoc.checkdoc_back.model.UserModel;

public interface DoctorRepository extends JpaRepository<DoctorModel, Long>{
    DoctorModel findByUser(UserModel user);
    DoctorModel findByUserId(Long userId);
    Optional<DoctorModel> findByUserEmail(String email);
    DoctorModel findByName(String name);
    List<DoctorModel> findBySpecialty(String specialty);
    
}
