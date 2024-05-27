package com.backend.internshipsystem.domain.dto;

import com.backend.internshipsystem.domain.entities.UserRole;

import java.util.Date;

public record RegisterAuthDTO(String login,
                              String senha,
                              UserRole role,
                              String nome,
                              String email,
                              int matricula,
                              Date data_nascimento) {
    public RegisterAuthDTO {
        if (role == null) {
            role = UserRole.USER;
        }
    }
}
