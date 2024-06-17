package com.github.lu_backend.models;

import com.github.lu_backend.dto.Course;
import com.github.lu_backend.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student implements Serializable {
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private List<Course> courseList;

    public static ResponseDTO toResponseDTO(Student student) {
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
