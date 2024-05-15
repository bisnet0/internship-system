package com.backend.internshipsystem.domain.dto;

import com.backend.internshipsystem.domain.entities.UserRole;

public record RegisterAuthDTO(String login,
                              String senha,
                              UserRole role) {
}
