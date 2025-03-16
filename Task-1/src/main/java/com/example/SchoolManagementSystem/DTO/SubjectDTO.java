package com.example.SchoolManagementSystem.DTO;

import lombok.Data;
import java.util.Set;

@Data
public class SubjectDTO {
    private Long id;
    private String subjectName;
    private Set<Long> studentIds;
}