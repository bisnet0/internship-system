package com.backend.internshipsystem.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record RequestStudentPutDTO(String id,
                                   @NotBlank
                                   String email,
                                   @NotNull
                                   String senha) {
}
