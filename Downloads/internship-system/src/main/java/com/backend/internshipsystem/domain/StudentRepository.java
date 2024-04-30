package com.backend.internshipsystem.domain;

import com.backend.internshipsystem.domain.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByLogin(String email);
//    List <Student> findAllByActiveTrue();
}
