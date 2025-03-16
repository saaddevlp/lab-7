package com.example.SchoolManagementSystem.service;


import com.example.SchoolManagementSystem.DTO.ClassRoomDTO;
import com.example.SchoolManagementSystem.entities.oneToMany.ClassRoom;
import com.example.SchoolManagementSystem.entities.oneToOne.Student;
import com.example.SchoolManagementSystem.repository.ClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassRoomService {

    @Autowired
    private ClassRoomRepository classRoomRepository;

    public ClassRoomDTO getClassRoomWithStudents(Long id) {
        Optional<ClassRoom> classRoom = classRoomRepository.findClassRoomWithStudentsById(id);
        return classRoom.map(this::convertToDTO).orElse(null);
    }

    private ClassRoomDTO convertToDTO(ClassRoom classRoom) {
        ClassRoomDTO dto = new ClassRoomDTO();
        dto.setId(classRoom.getId());
        dto.setClassName(classRoom.getClassName());
        dto.setStudentIds(classRoom.getStudents().stream().map(Student::getId).toList());
        return dto;
    }
}
