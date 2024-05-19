package com.backend.internshipsystem.domain.repositories;

import com.backend.internshipsystem.domain.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository <Company, UUID> {
//    Company findByRazaoSocial(String razao_social);
}
