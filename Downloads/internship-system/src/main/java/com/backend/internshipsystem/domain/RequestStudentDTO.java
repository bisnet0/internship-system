package com.backend.internshipsystem.domain;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record RequestStudentDTO(String id,
                                String nome,
                                @NotBlank
                                String email,
                                String login,
                                @NotNull
                                String senha,
                                Integer matricula,
                                Date data_nascimento,
                                String biografia) {


}

