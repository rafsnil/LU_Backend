package com.github.lu_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
public class Course implements Serializable {
    private String courseId;
    private String courseName;
}
