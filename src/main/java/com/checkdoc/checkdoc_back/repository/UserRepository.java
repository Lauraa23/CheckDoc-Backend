package com.checkdoc.checkdoc_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.checkdoc.checkdoc_back.model.UserModel;


public interface UserRepository extends JpaRepository<UserModel, Long>{
    UserModel findByEmail(String email);
    Long findIdByEmail(String email);
    void deleteByEmail(String email);
}
