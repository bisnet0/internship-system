package com.backend.internshipsystem.controllers;

import com.backend.internshipsystem.domain.repositories.CompanyRepository;
import com.backend.internshipsystem.domain.dto.RequestCompanyDTO;
import com.backend.internshipsystem.domain.entities.Company;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    public CompanyRepository companyRepository;

    @GetMapping
    public ResponseEntity getAllCompany (){
        var allCompanys = companyRepository.findAll();
        return ResponseEntity.ok(allCompanys);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCompany(@PathVariable Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()) {
            return ResponseEntity.ok(company.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity registerCompany (@RequestBody @Valid RequestCompanyDTO data){
        Company company = new Company(data);
        companyRepository.save(company);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateCompany (@RequestBody @Valid RequestCompanyDTO data){
        Long id = data.id();
        Optional <Company> company = companyRepository.findById(id);
        if (company.isPresent()){
            company.get().setName(data.name());
            company.get().setEmail(data.email());
            company.get().setCnpj(data.cnpj());
            return ResponseEntity.ok(company);
        }else{
            throw new EntityNotFoundException();
        }
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCompany (@PathVariable Long id){
        Optional <Company> company = companyRepository.findById(id);
        if(company.isPresent()){
            companyRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            throw new EntityNotFoundException();
        }
    }

}
