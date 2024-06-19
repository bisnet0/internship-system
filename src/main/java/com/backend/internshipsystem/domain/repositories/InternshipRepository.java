package com.backend.internshipsystem.domain.repositories;

import com.backend.internshipsystem.domain.entities.Internship;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface InternshipRepository extends JpaRepository<Internship, UUID> {
    List<Internship> findAllByCity(@NotNull String city);
    List<Internship> findAllByRemote(@NotNull Boolean remote);
    List<Internship> findAllByShift(@NotNull String shift);
    List<Internship> findAllBySalary(@NotNull Double salary);
    List<Internship> findAllByCompany_Id(@NotNull UUID companyId);
    List<Internship> findAllByExpirationDate(@NotNull LocalDateTime expirationDate);

    List<Internship> findByIdIn(Collection<UUID> uniqueIds);
}