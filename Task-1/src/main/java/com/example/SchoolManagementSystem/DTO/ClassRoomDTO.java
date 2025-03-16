package com.example.SchoolManagementSystem.DTO;

import lombok.Data;
import java.util.List;

@Data
public class ClassRoomDTO {
    private Long id;
    private String className;
    private List<Long> studentIds;
}