package com.github.lu_backend.services;

import com.github.lu_backend.dto.CreateStudentRequestDTO;
import com.github.lu_backend.dto.ResponseDTO;

public interface StudentService {
    ResponseDTO createStudent(CreateStudentRequestDTO requestDTO) throws Exception;
    ResponseDTO updateStudent(String id, CreateStudentRequestDTO requestDTO) throws Exception;
    ResponseDTO getStudentById(String id) throws Exception;
    ResponseDTO deleteStudentById(String id) throws Exception;
}
