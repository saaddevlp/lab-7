package com.example.SchoolManagementSystem.DTO;

import lombok.Data;

import java.util.Set;

@Data
public class StudentDTO {
    private Long id;
    private String name;
    private StudentProfileDTO profile;
    private Long classRoomId;
    private Set<Long> subjectIds;
}