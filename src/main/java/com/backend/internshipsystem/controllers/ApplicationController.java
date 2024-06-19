package com.backend.internshipsystem.controllers;

import com.backend.internshipsystem.domain.entities.Internship;
import com.backend.internshipsystem.domain.entities.Student;
import com.backend.internshipsystem.domain.repositories.ApplicationRepository;
import com.backend.internshipsystem.domain.entities.Application;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Application Controller", description = "Operations related to applications")
public class ApplicationController {
    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping
    @Operation(summary = "Get all applications", description = "Retrieve all applications. Optionally filter by studentId and/or internshipId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the applications",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Application.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid request parameters",
                    content = @Content)
    })
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

    @Operation(summary = "Get an application by ID", description = "Retrieve a single application by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the application",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Application.class)) }),
            @ApiResponse(responseCode = "404", description = "Application not found",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplication (@PathVariable Long id){
        return applicationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new application", description = "Create a new application and return the created application.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Application created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Application.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<Application> createApplication (@RequestBody Application application){
        Application savedApplication = applicationRepository.save(application);
        return ResponseEntity.ok(savedApplication);
    }

    @Operation(summary = "Update an existing application", description = "Update an existing application and return the updated application.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Application updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Application.class)) }),
            @ApiResponse(responseCode = "404", description = "Application not found",
                    content = @Content)
    })
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

    @Operation(summary = "Delete an application by ID", description = "Delete an application by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Application deleted",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Application not found",
                    content = @Content)
    })
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