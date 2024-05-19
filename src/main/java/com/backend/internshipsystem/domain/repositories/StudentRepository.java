package com.backend.internshipsystem.domain.repositories;

import com.backend.internshipsystem.domain.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
//    Student findByLogin(String email);
//    List <Student> findAllByActiveTrue();
}
