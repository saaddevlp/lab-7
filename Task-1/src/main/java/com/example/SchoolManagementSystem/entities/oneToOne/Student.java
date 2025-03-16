package com.example.SchoolManagementSystem.entities.oneToOne;

import com.example.SchoolManagementSystem.entities.manyToMany.Subject;
import com.example.SchoolManagementSystem.entities.oneToMany.ClassRoom;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private StudentProfile profile;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassRoom classRoom;

    @ManyToMany
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjects = new HashSet<>();
}
