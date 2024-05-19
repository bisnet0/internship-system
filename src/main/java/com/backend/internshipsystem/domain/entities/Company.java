package com.backend.internshipsystem.domain.entities;

import com.backend.internshipsystem.domain.dto.RequestCompanyDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "company")
@Entity(name = "company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Company {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String email;
    private String biografia;
    private String razao_social;
    private String cnpj;


    public Company (RequestCompanyDTO requestCompanyDTO){
        this.nome = requestCompanyDTO.nome();
        this.email = requestCompanyDTO.email();
        this.biografia = requestCompanyDTO.biografia();
        this.razao_social = requestCompanyDTO.razao_social();
        this.cnpj = requestCompanyDTO.cnpj();
    }
}
