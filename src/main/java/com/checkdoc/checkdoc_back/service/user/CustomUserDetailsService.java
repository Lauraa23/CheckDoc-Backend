package com.checkdoc.checkdoc_back.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.checkdoc.checkdoc_back.model.CustomUserDetails;
import com.checkdoc.checkdoc_back.model.DoctorDetails;
import com.checkdoc.checkdoc_back.model.DoctorModel;
import com.checkdoc.checkdoc_back.model.UserModel;
import com.checkdoc.checkdoc_back.repository.DoctorRepository;
import com.checkdoc.checkdoc_back.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        DoctorModel doctor = doctorRepository.findByUserEmail(email).orElse(null);

        if (doctor != null) {
            return new DoctorDetails(doctor);
        }

        UserModel user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        return new CustomUserDetails(user);
    }
}
