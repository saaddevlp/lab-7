package com.example.SchoolManagementSystem.service;


import com.example.SchoolManagementSystem.DTO.SubjectDTO;
import com.example.SchoolManagementSystem.entities.manyToMany.Subject;
import com.example.SchoolManagementSystem.entities.oneToOne.Student;
import com.example.SchoolManagementSystem.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public SubjectDTO getSubjectWithStudents(Long id) {
        Optional<Subject> subject = subjectRepository.findSubjectWithStudentsById(id);
        return subject.map(this::convertToDTO).orElse(null);
    }

    private SubjectDTO convertToDTO(Subject subject) {
        SubjectDTO dto = new SubjectDTO();
        dto.setId(subject.getId());
        dto.setSubjectName(subject.getSubjectName());
        dto.setStudentIds(subject.getStudents().stream().map(Student::getId).toList());
        return dto;
    }
}
