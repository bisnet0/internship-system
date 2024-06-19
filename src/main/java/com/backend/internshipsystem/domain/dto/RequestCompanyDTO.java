package com.backend.internshipsystem.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestCompanyDTO(Long id,
                                @NotBlank
                                String name,
                                String email,
                                @NotNull
                                String cnpj) {
}
