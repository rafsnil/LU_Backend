package com.github.lu_backend.services;

import com.github.lu_backend.dto.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCourseByStudentId(String studentId) throws Exception;
}
