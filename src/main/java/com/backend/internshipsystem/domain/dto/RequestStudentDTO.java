package com.backend.internshipsystem.domain.dto;
import com.backend.internshipsystem.domain.entities.User;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record RequestStudentDTO(Long id,
                                String name,
                                @NotBlank
                                String email,
                                Integer enrollment,
                                Date birthDate,
                                User user) {
}

