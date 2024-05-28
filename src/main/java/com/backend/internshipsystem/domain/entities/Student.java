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
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String email;
    private int matricula;
    private Date data_nascimento;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

    public Student(RequestStudentDTO requestStudentDTO){
        this.nome = requestStudentDTO.nome();
        this.email = requestStudentDTO.email();
        this.matricula = requestStudentDTO.matricula();
        this.data_nascimento = requestStudentDTO.data_nascimento();
        this.user = (requestStudentDTO.user());

    }

    public Student(String nome, String email, int matricula, Date date, User newUser) {
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.data_nascimento = date;
        this.user = newUser;
    }
}





