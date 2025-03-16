package com.example.SchoolManagementSystem.controller;


import com.example.SchoolManagementSystem.DTO.ClassRoomDTO;
import com.example.SchoolManagementSystem.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classrooms")
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;

    @GetMapping("/{id}/students")
    public ResponseEntity<ClassRoomDTO> getClassRoomWithStudents(@PathVariable Long id) {
        ClassRoomDTO classRoomDTO = classRoomService.getClassRoomWithStudents(id);
        return classRoomDTO != null ? ResponseEntity.ok(classRoomDTO) : ResponseEntity.notFound().build();
    }
}
