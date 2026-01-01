package com.librarymanagementsystem.controller;

import com.librarymanagementsystem.dto.AuthResponse;
import com.librarymanagementsystem.dto.UserDTO;
import com.librarymanagementsystem.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@CrossOrigin // Frontend එක වෙනම Port එකක දුවන නිසා
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(authService.register(userDTO), HttpStatus.CREATED);
    }
}
