package com.checkdoc.checkdoc_back.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.checkdoc.checkdoc_back.model.UserModel;
import com.checkdoc.checkdoc_back.service.user.CreateUser;

@RestController
public class CreateUserController {
    
    @Autowired
    private CreateUser createUser;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/user/createUser")
    public ResponseEntity<String> createUser(
        @RequestParam("name") String name,
        @RequestParam("email") String email,
        @RequestParam("password") String password) {
            try {
                String encodedPassword = passwordEncoder.encode(password);

                UserModel user = new UserModel();
                user.setName(name);
                user.setEmail(email);
                user.setPassword(encodedPassword);
                user.setRole("patient");

                createUser.saveUser(user);

                return ResponseEntity.ok("Patient created succesfully");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Patient created failed" + e.getMessage());
            }
        }
}
