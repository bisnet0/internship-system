package com.backend.internshipsystem.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestCompanyDTO(String id,
                                @NotBlank
                                String nome,
                                String email,
                                @NotBlank
                                String login,
                                @NotNull
                                String senha,
                                String biografia,
                                String razao_social,
                                @NotNull
                                String cnpj) {
}
