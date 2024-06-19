package com.backend.internshipsystem.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;
/**
 * Represents an application for an internship by a student.
 */
@Entity
@Table(name = "applications")
@Data
public class Application {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="studentId", nullable=false)
    private Student student;

    @ManyToOne
    @JoinColumn(name="internshipId", nullable=false)
    private Internship internship;

    @NotNull
    private String description;
}