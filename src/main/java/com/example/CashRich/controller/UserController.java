package com.example.CashRich.controller;

import com.example.CashRich.entity.User;
import com.example.CashRich.service.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp( @Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.signUp(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {

        return ResponseEntity.ok("Login successful");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable Long id,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String mobile,
            @RequestParam String password) {

        User updatedUser = userService.updateUser(id, firstName, lastName, mobile, password);
        return ResponseEntity.ok(updatedUser);
    }
}
