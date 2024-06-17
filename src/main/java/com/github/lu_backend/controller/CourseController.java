package com.github.lu_backend.controller;

import com.github.lu_backend.services.CourseService;
import com.github.lu_backend.services.utilities.Common;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping(value = "/{studentId}")
    public ResponseEntity<?> createCourse(@PathVariable("studentId") String id) throws Exception {
        return Common.sendResponse(HttpStatus.OK, "Enrolled Courses Retrieved Successfully!", courseService.getCourseByStudentId(id));
    }
}
