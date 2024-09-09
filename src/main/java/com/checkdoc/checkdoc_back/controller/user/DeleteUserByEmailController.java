package com.checkdoc.checkdoc_back.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.checkdoc.checkdoc_back.service.user.DeleteUser;

@RestController
public class DeleteUserByEmailController {
    
    @Autowired
    private DeleteUser deleteUser;

    @DeleteMapping("/user/deleteUserByEmail")
    public ResponseEntity<String> deleteUser(@RequestParam("email") String email) {
        try {
            deleteUser.deleteUserByEmail(email);
            return ResponseEntity.ok("Patient removed");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error removing patient " + e);
        }
    }
}
