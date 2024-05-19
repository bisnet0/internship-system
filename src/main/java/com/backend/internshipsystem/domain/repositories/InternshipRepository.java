package com.backend.internshipsystem.domain.repositories;

import com.backend.internshipsystem.domain.entities.Internship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InternshipRepository extends JpaRepository<Internship, UUID> {
}