package com.backend.internshipsystem.domain.entities;

import com.backend.internshipsystem.domain.dto.RequestStudentDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Table(name = "student")
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

    public Student(RequestStudentDTO requestStudentDTO){
        this.nome = requestStudentDTO.nome();
        this.email = requestStudentDTO.email();
        this.matricula = requestStudentDTO.matricula();
        this.data_nascimento = requestStudentDTO.data_nascimento();

    }
}





