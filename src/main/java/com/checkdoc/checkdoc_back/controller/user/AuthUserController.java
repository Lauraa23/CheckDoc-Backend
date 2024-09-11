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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.checkdoc.checkdoc_back.model.LoginRequest;
import com.checkdoc.checkdoc_back.model.LoginResponseDTO;
import com.checkdoc.checkdoc_back.service.jwt.JwtUtils;
import com.checkdoc.checkdoc_back.service.user.GetUser;

@RestController
public class AuthUserController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private GetUser getUser;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/user/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
          } catch (AuthenticationException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong parameters");
          }
   
          final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
          final String jwt = jwtUtils.generateToken(userDetails.getUsername());
          
          final LoginResponseDTO response = getUser.parseUserResponse(loginRequest.getEmail(), jwt);

          return ResponseEntity.ok(response);
    }
}
