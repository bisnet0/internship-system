package com.backend.internshipsystem.controllers;

import com.backend.internshipsystem.domain.repositories.InternshipRepository;
import com.backend.internshipsystem.domain.entities.Internship;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/internship")
public class InternshipController {
    @Autowired
    private InternshipRepository internshipRepository;

    @GetMapping
    public ResponseEntity<List<Internship>> getAllInternships(
            @RequestParam Optional<Long> id,
            @RequestParam Optional<String> title,
            @RequestParam Optional<UUID> company_id,
            @RequestParam Optional<Double> salary,
            @RequestParam Optional<LocalDateTime> expirationDate,
            @RequestParam Optional<Boolean> remote,
            @RequestParam Optional<String> city,
            @RequestParam Optional<String> shift) {

        List<Internship> internships = internshipRepository.findAll();

        if (city.isPresent()) {
            internships = internships.stream()
                    .filter(internship -> city.get().equals(internship.getCity()))
                    .collect(Collectors.toList());
        }
        if (remote.isPresent()) {
            internships = internships.stream()
                    .filter(internship -> remote.get().equals(internship.getRemote()))
                    .collect(Collectors.toList());
        }
        if (shift.isPresent()) {
            internships = internships.stream()
                    .filter(internship -> shift.get().equals(internship.getShift()))
                    .collect(Collectors.toList());
        }
        if (salary.isPresent()) {
            internships = internships.stream()
                    .filter(internship -> salary.get().equals(internship.getSalary()))
                    .collect(Collectors.toList());
        }
        if (company_id.isPresent()) {
            internships = internships.stream()
                    .filter(internship -> company_id.get().equals(internship.getCompany().getId()))
                    .collect(Collectors.toList());
        }
        if (expirationDate.isPresent()) {
            try {
                internships = internships.stream()
                        .filter(internship -> expirationDate.equals(internship.getExpirationDate()))
                        .collect(Collectors.toList());
            } catch (DateTimeParseException e) {
                System.err.println("Erro ao parsear a data de expiração: " + e.getMessage());
            }
        }

        return ResponseEntity.ok(internships);
    }




    @GetMapping("/{id}")
    public ResponseEntity<Internship> getInternship(@PathVariable Long id){
        return internshipRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity createInternship (@RequestBody Internship internship){
        internshipRepository.save(internship);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateInternship (@RequestBody Internship updatedInternship){
        Optional<Internship> internship = internshipRepository.findById(updatedInternship.getId());
        if (internship.isPresent()){
            internship.get().setTitle(updatedInternship.getTitle());
            internship.get().setDescription(updatedInternship.getDescription());
            internship.get().setCompany(updatedInternship.getCompany());
            internship.get().setExpirationDate(updatedInternship.getExpirationDate());
            internship.get().setRemote(updatedInternship.getRemote());
            internship.get().setSalary(updatedInternship.getSalary());
            internship.get().setCity(updatedInternship.getCity());
            internship.get().setShift(updatedInternship.getShift());
            this.internshipRepository.save(internship.get());
            return ResponseEntity.ok(internship);
        }else{
            throw new EntityNotFoundException();
        }
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deleteInternship (@PathVariable Long id){
        Optional<Internship> internship = internshipRepository.findById(id);
        if(internship.isPresent()){
            internshipRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            throw new EntityNotFoundException();
        }
    }
}