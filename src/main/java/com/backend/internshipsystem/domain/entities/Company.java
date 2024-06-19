package com.backend.internshipsystem.domain.entities;

import com.backend.internshipsystem.domain.dto.RequestCompanyDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "companys")
@Entity(name = "company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Company {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cnpj;


    public Company (RequestCompanyDTO requestCompanyDTO){
        this.name = requestCompanyDTO.name();
        this.email = requestCompanyDTO.email();
        this.cnpj = requestCompanyDTO.cnpj();
    }
}
