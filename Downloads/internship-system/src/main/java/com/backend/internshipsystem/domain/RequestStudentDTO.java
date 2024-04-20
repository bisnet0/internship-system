package com.backend.internshipsystem.domain;

import java.util.Date;

public record RequestStudentDTO(String nome,
                                String email, String login,
                                String senha, Integer matricula,
                                Date data_nascimento, String biografia) {


}
