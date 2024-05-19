package com.backend.internshipsystem.controllers;

import com.backend.internshipsystem.domain.repositories.InternshipRepository;
import com.backend.internshipsystem.domain.entities.Internship;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/internship")
public class InternshipController {
    @Autowired
    private InternshipRepository internshipRepository;

    @GetMapping
    public ResponseEntity getAllInternships (){
        var allInternships = internshipRepository.findAll();
        return ResponseEntity.ok(allInternships);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Internship> getInternship(@PathVariable UUID id){
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
            return ResponseEntity.ok(internship);
        }else{
            throw new EntityNotFoundException();
        }
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity deleteInternship (@PathVariable UUID id){
        Optional<Internship> internship = internshipRepository.findById(id);
        if(internship.isPresent()){
            internshipRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            throw new EntityNotFoundException();
        }
    }
}