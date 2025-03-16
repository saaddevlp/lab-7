package com.example.SchoolManagementSystem.repository;

import com.example.SchoolManagementSystem.entities.manyToMany.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    @Query("SELECT s FROM Subject s JOIN FETCH s.students WHERE s.id = :id")
    Optional<Subject> findSubjectWithStudentsById(@Param("id") Long id);
}
