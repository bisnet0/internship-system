package com.backend.internshipsystem.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestCompanyDTO(String id,
                                @NotBlank
                                String nome,
                                String email,
                                String biografia,
                                String razao_social,
                                @NotNull
                                String cnpj) {
}
