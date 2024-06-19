package com.backend.internshipsystem.controllers;

import com.backend.internshipsystem.domain.entities.Internship;
import com.backend.internshipsystem.domain.entities.Student;
import com.backend.internshipsystem.domain.repositories.ApplicationRepository;
import com.backend.internshipsystem.domain.entities.Application;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications (
            @RequestParam(value = "studentId", required = false) Long studentId,
            @RequestParam(value = "internshipId", required = false) Long internshipId
    ){
        List<Application> applications;
        if (studentId != null && internshipId != null) {
            Student student = new Student();
            student.setId(studentId);
            Internship internship = new Internship();
            internship.setId(internshipId);
            applications = applicationRepository.findByInternshipAndStudent(internship, student);
        } else if (studentId != null) {
            Student student = new Student();
            student.setId(studentId);
            applications = applicationRepository.findByStudent(student);
        } else if (internshipId != null) {
            Internship internship = new Internship();
            internship.setId(internshipId);
            applications = applicationRepository.findByInternship(internship);
        } else {
            applications = applicationRepository.findAll();
        }

        return ResponseEntity.ok(applications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplication (@PathVariable Long id){
        return applicationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Application> createApplication (@RequestBody Application application){
        Application savedApplication = applicationRepository.save(application);
        return ResponseEntity.ok(savedApplication);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> updateApplication (@RequestBody Application updatedApplication){
        return applicationRepository.findById(updatedApplication.getId())
                .map(application -> {
                    application.setStudent(updatedApplication.getStudent());
                    application.setInternship(updatedApplication.getInternship());
                    application.setDescription(updatedApplication.getDescription());
                    return ResponseEntity.ok(application);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteApplication (@PathVariable Long id){
        return applicationRepository.findById(id)
                .map(application -> {
                    applicationRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}