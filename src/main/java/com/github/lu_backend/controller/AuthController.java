package com.github.lu_backend.controller;

import com.github.lu_backend.dto.LoginRequestDTO;
import com.github.lu_backend.dto.ResponseDTO;
import com.github.lu_backend.models.Student;
import com.github.lu_backend.repository.StudentRepository;
import com.github.lu_backend.services.utilities.Common;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/student/login")
public class AuthController {
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        Student student = studentRepository.findByUsername(loginRequest.getUsername()).orElse(null);
        if (student != null && passwordEncoder.matches(loginRequest.getPassword(), student.getPassword())) {
            return Common.sendResponse(HttpStatus.OK, "Login successful", ResponseDTO.toResponseDTO(student));
        }
        return Common.sendResponse(HttpStatus.BAD_REQUEST, "Invalid username or password", ResponseDTO.toResponseDTO(student));
    }
}
