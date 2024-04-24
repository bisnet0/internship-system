package com.backend.internshipsystem.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByLogin(String email);
//    List <Student> findAllByActiveTrue();
}
