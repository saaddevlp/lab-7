package com.example.SchoolManagementSystem.entities.manyToMany;

import com.example.SchoolManagementSystem.entities.oneToOne.Student;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subjectName;

    @ManyToMany(mappedBy = "subjects")
    private Set<Student> students;
}
