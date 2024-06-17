package com.github.lu_backend.services.implementation;

import com.github.lu_backend.configuration.ApiException;
import com.github.lu_backend.dto.CreateStudentRequestDTO;
import com.github.lu_backend.dto.ResponseDTO;
import com.github.lu_backend.models.Student;
import com.github.lu_backend.repository.StudentRepository;
import com.github.lu_backend.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseDTO createStudent(CreateStudentRequestDTO requestDTO) throws Exception {
        Optional<Student> student = studentRepository.findByUsername(requestDTO.getUsername());
        if (student.isPresent()) {
            throw new ApiException("Username already exists", HttpStatus.BAD_REQUEST);
        }

        Student newStudent = CreateStudentRequestDTO.toDatabaseStudentDocument(requestDTO);
        newStudent.setPassword(passwordEncoder.encode(requestDTO.getPassword()));

        Student savedStudent = studentRepository.save(newStudent);
        return Student.toResponseDTO(savedStudent);
    }

    @Override
    public ResponseDTO updateStudent(String id, CreateStudentRequestDTO requestDTO) throws Exception {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ApiException("Student not found", HttpStatus.BAD_REQUEST));
        student.setFirstName(requestDTO.getFirstName());
        student.setLastName(requestDTO.getLastName());
        student.setUsername(requestDTO.getUsername());
        student.setEmail(requestDTO.getEmail());
        student.setPassword(requestDTO.getPassword());
        student.setCourseList(requestDTO.getCourseList());
        Student updatedStudent = studentRepository.save(student);
        return Student.toResponseDTO(updatedStudent);
    }

    @Override
    public ResponseDTO getStudentById(String id) throws Exception {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ApiException("Student not found", HttpStatus.BAD_REQUEST));
        return Student.toResponseDTO(student);
    }

    @Override
    public ResponseDTO deleteStudentById(String id) throws Exception {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ApiException("Student not found", HttpStatus.BAD_REQUEST));
        studentRepository.delete(student);
        return Student.toResponseDTO(student);
    }
}
