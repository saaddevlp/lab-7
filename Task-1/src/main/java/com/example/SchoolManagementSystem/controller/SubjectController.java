package com.example.SchoolManagementSystem.controller;


import com.example.SchoolManagementSystem.DTO.SubjectDTO;
import com.example.SchoolManagementSystem.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/{id}/students")
    public ResponseEntity<SubjectDTO> getSubjectWithStudents(@PathVariable Long id) {
        SubjectDTO subjectDTO = subjectService.getSubjectWithStudents(id);
        return subjectDTO != null ? ResponseEntity.ok(subjectDTO) : ResponseEntity.notFound().build();
    }
}