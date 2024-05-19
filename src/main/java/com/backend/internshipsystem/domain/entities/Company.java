package com.backend.internshipsystem.domain.entities;

import com.backend.internshipsystem.domain.dto.RequestCompanyDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "company")
@Entity(name = "company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Company {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String email;
    private String cnpj;


    public Company (RequestCompanyDTO requestCompanyDTO){
        this.nome = requestCompanyDTO.nome();
        this.email = requestCompanyDTO.email();
        this.cnpj = requestCompanyDTO.cnpj();
    }
}
