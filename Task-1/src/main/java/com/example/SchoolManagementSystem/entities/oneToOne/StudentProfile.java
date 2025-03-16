package com.example.SchoolManagementSystem.entities.oneToOne;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateOfBirth;
    private String address;
    private String contactInfo;

    @OneToOne(mappedBy = "profile")
    private Student student;
}
