package com.backend.internshipsystem.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "student")
@Entity(name= "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")


public class Student {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    private String nome;
    private String email;
    private String login;
    private String senha;
    private int matricula;
    private Date data_nascimento;
    private String biografia;

    public Student(RequestStudentDTO requestStudentDTO){
        this.nome = requestStudentDTO.nome();
        this.email = requestStudentDTO.email();
        this.login = requestStudentDTO.login();
        this.senha = requestStudentDTO.senha();
        this.matricula = requestStudentDTO.matricula();
        this.data_nascimento = requestStudentDTO.data_nascimento();
        this.biografia = requestStudentDTO.biografia();

    }
}
