package com.backend.internshipsystem.domain.entities;

import com.backend.internshipsystem.domain.dto.RequestStudentDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Table(name = "students")
@Entity(name= "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")


public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int enrollment;
    @Column(name = "birth_date")
    private Date birthDate;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

    public Student(RequestStudentDTO requestStudentDTO){
        this.name = requestStudentDTO.name();
        this.email = requestStudentDTO.email();
        this.enrollment = requestStudentDTO.enrollment();
        this.birthDate = requestStudentDTO.birthDate();
        this.user = (requestStudentDTO.user());

    }

    public Student(String nome, String email, int enrollment, Date birthDate, User newUser) {
        this.name = nome;
        this.email = email;
        this.enrollment = enrollment;
        this.birthDate = birthDate;
        this.user = newUser;
    }
}





