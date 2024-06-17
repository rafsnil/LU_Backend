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
public class ResponseDTO implements Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private List<Course> courseList;

    public static ResponseDTO toResponseDTO(Student student){
        return ResponseDTO.builder()
                .id(student.getId().toHexString())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .username(student.getUsername())
                .email(student.getEmail())
                .courseList(student.getCourseList())
                .build();
    }
}
