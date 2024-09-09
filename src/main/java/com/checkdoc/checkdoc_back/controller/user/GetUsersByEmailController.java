package com.checkdoc.checkdoc_back.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.checkdoc.checkdoc_back.model.UserModel;
import com.checkdoc.checkdoc_back.service.user.GetUser;

@RestController
public class GetUsersByEmailController {
    
    @Autowired
    private GetUser getUser;

    @GetMapping("/user/getUserByEmail")
    public ResponseEntity<?> getUserByEmail(@RequestParam("email") String email) {
        try {
            UserModel user = getUser.getUserByEmail(email);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.status(404).body("User not found with email: " + email);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }
}
