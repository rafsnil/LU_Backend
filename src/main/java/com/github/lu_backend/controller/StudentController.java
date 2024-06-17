package com.github.lu_backend.controller;

import com.github.lu_backend.dto.CreateStudentRequestDTO;
import com.github.lu_backend.services.StudentService;
import com.github.lu_backend.services.utilities.Common;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody CreateStudentRequestDTO requestDTO) throws Exception {
        return Common.sendResponse(HttpStatus.CREATED, "Student Account Created Successfully!", studentService.createStudent(requestDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") String id, @RequestBody CreateStudentRequestDTO requestDTO) throws Exception {
        return Common.sendResponse(HttpStatus.OK, "Student Account Updated Successfully!", studentService.updateStudent(id, requestDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") String id) throws Exception {
        return Common.sendResponse(HttpStatus.OK, "Student Account Deleted Successfully!", studentService.deleteStudentById(id));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") String id) throws Exception {
        return Common.sendResponse(HttpStatus.OK, "Student Account Retrieved Successfully!", studentService.getStudentById(id));
    }

}
