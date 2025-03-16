package com.example.SchoolManagementSystem.repository;


import com.example.SchoolManagementSystem.entities.oneToMany.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {
    @Query("SELECT c FROM ClassRoom c JOIN FETCH c.students WHERE c.id = :id")
    Optional<ClassRoom> findClassRoomWithStudentsById(@Param("id") Long id);
}