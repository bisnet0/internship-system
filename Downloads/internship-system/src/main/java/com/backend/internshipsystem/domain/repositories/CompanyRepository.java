package com.backend.internshipsystem.domain.repositories;

import com.backend.internshipsystem.domain.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository <Company, String> {
//    Company findByRazaoSocial(String razao_social);
}
