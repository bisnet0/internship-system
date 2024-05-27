package com.backend.internshipsystem.domain.dto;
import com.backend.internshipsystem.domain.entities.User;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record RequestStudentDTO(String id,
                                String nome,
                                @NotBlank
                                String email,
                                Integer matricula,
                                Date data_nascimento,
                                User user) {
}

