package com.checkdoc.checkdoc_back.security;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.checkdoc.checkdoc_back.security.jwt.JwtRequestFilter;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Autowired
    @Lazy
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf((csrf) -> csrf.ignoringRequestMatchers("/**"))
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .authorizeHttpRequests(authRequest -> authRequest
            .requestMatchers(HttpMethod.GET, "/doctor/**").permitAll()
            .requestMatchers(HttpMethod.POST, "/doctor/**").permitAll()
            .requestMatchers(HttpMethod.POST, "/user/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/user/**").permitAll()
            .requestMatchers(HttpMethod.DELETE, "/doctor/deleteDoctorByEmail").authenticated()
            .requestMatchers(HttpMethod.DELETE, "/user/deleteUserByEmail").authenticated()
            .requestMatchers(HttpMethod.POST, "/appointment/create").authenticated()
            .requestMatchers(HttpMethod.PUT, "/appointment/cancellAppointment").authenticated()
            .requestMatchers(HttpMethod.PUT, "/appointment/updateAppointment").authenticated()
            .requestMatchers(HttpMethod.GET, "/appointment/getAppointmentsByDoctorId").authenticated()
            .requestMatchers(HttpMethod.GET, "/appointment/getAppoinmentByUser").authenticated()
            ).addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
            return http.build();
    }

   @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

   @Bean

    public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(List.of("http://localhost:5173")); 
    configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    configuration.setAllowedHeaders(List.of("*"));
    configuration.setExposedHeaders(List.of("*"));
    configuration.setAllowCredentials(true);

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);

    return source;
}

}
