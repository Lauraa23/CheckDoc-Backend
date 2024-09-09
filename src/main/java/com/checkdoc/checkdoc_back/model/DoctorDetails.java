package com.checkdoc.checkdoc_back.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class DoctorDetails implements UserDetails {

    private final DoctorModel doctor;

    public DoctorDetails(DoctorModel doctor) {
        this.doctor = doctor;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Puedes ajustar el rol del usuario aquí
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_DOCTOR"));
    }

    @Override
    public String getPassword() {
        return doctor.getUser().getPassword(); // Asumiendo que el password está en UserModel
    }

    @Override
    public String getUsername() {
        return doctor.getUser().getEmail(); // Asumiendo que el email está en UserModel
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Implementa lógica adicional aquí si es necesario
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implementa lógica adicional aquí si es necesario
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implementa lógica adicional aquí si es necesario
    }

    @Override
    public boolean isEnabled() {
        return true; // Implementa lógica adicional aquí si es necesario
    }

    public DoctorModel getDoctor() {
        return doctor;
    }
}
