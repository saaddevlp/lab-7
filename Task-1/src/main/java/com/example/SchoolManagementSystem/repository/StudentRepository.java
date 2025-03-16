package com.example.SchoolManagementSystem.repository;

import com.example.SchoolManagementSystem.entities.oneToOne.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s JOIN FETCH s.profile WHERE s.id = :id")
    Optional<Student> findStudentWithProfileById(@Param("id") Long id);

    @Query("SELECT s FROM Student s JOIN FETCH s.subjects WHERE s.id = :id")
    Optional<Student> findStudentWithSubjectsById(@Param("id") Long id);
}