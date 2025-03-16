package com.example.SchoolManagementSystem.service;


import com.example.SchoolManagementSystem.DTO.StudentDTO;
import com.example.SchoolManagementSystem.DTO.StudentProfileDTO;
import com.example.SchoolManagementSystem.entities.oneToOne.Student;
import com.example.SchoolManagementSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentDTO getStudentWithProfile(Long id) {
        Optional<Student> student = studentRepository.findStudentWithProfileById(id);
        return student.map(this::convertToDTO).orElse(null);
    }

    public StudentDTO getStudentWithSubjects(Long id) {
        Optional<Student> student = studentRepository.findStudentWithSubjectsById(id);
        return student.map(this::convertToDTO).orElse(null);
    }

    private StudentDTO convertToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setProfile(new StudentProfileDTO());
        dto.getProfile().setDateOfBirth(student.getProfile().getDateOfBirth());
        dto.getProfile().setAddress(student.getProfile().getAddress());
        dto.getProfile().setContactInfo(student.getProfile().getContactInfo());
        return dto;
    }
}