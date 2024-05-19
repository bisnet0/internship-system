package com.backend.internshipsystem.domain.repositories;

import com.backend.internshipsystem.domain.entities.Application;
import com.backend.internshipsystem.domain.entities.Internship;
import com.backend.internshipsystem.domain.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ApplicationRepository extends JpaRepository<Application, UUID> {
    List<Application> findByStudent(Student student);
    List<Application> findByInternship(Internship internship);
}