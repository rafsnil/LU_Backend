package com.github.lu_backend.dto;

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
public class UpdateStudentRequestDTO implements Serializable {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private List<Course> courseList;
}
