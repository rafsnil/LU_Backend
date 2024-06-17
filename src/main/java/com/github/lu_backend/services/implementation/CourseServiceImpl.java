package com.github.lu_backend.services.implementation;

import com.github.lu_backend.dto.Course;
import com.github.lu_backend.models.Student;
import com.github.lu_backend.repository.StudentRepository;
import com.github.lu_backend.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final StudentRepository studentRepository;

    @Override
    public List<Course> getCourseByStudentId(String studentId) throws Exception {
        Student studentFromDb = studentRepository.findById(studentId)
                .orElseThrow(() -> new Exception("Student not found"));
        return studentFromDb.getCourseList();
    }
}
