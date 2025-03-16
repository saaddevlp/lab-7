package com.example.SchoolManagementSystem.controller;


import com.example.SchoolManagementSystem.DTO.StudentDTO;
import com.example.SchoolManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}/profile")
    public ResponseEntity<StudentDTO> getStudentWithProfile(@PathVariable Long id) {
        StudentDTO studentDTO = studentService.getStudentWithProfile(id);
        return studentDTO != null ? ResponseEntity.ok(studentDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/subjects")
    public ResponseEntity<StudentDTO> getStudentWithSubjects(@PathVariable Long id) {
        StudentDTO studentDTO = studentService.getStudentWithSubjects(id);
        return studentDTO != null ? ResponseEntity.ok(studentDTO) : ResponseEntity.notFound().build();
    }
}
