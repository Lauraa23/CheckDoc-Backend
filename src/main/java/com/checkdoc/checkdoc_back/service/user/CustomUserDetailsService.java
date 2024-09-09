package com.checkdoc.checkdoc_back.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.checkdoc.checkdoc_back.model.DoctorDetails;
import com.checkdoc.checkdoc_back.model.DoctorModel;
import com.checkdoc.checkdoc_back.repository.DoctorRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        DoctorModel doctor = doctorRepository.findByUserEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Doctor not found with email: " + email));
        return new DoctorDetails(doctor);
    }
}
