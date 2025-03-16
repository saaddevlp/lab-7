package com.example.SchoolManagementSystem.entities.oneToMany;

import com.example.SchoolManagementSystem.entities.oneToOne.Student;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String className;

    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students;
}
