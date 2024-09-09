package com.checkdoc.checkdoc_back.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.checkdoc.checkdoc_back.service.jwt.JwtUtils;

@RestController
public class AuthUserController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/user/login")
    public ResponseEntity<String> login(@RequestParam("email") String email, @RequestParam("password") String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
          } catch (AuthenticationException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong parameters");
          }
   
          final UserDetails userDetails = userDetailsService.loadUserByUsername(email);
          final String jwt = jwtUtils.generateToken(userDetails.getUsername());
   
          return ResponseEntity.ok(jwt);
    }
}
