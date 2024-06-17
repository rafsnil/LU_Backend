package com.github.lu_backend.dto;

import com.github.lu_backend.models.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentRequestDTO implements Serializable {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private List<Course> courseList;

    public static Student toDatabaseStudentDocument(CreateStudentRequestDTO student) {
        return Student.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .username(student.getUsername())
                .email(student.getEmail())
                .password(student.getPassword())
                .courseList(student.getCourseList())
                .build();
    }
}
