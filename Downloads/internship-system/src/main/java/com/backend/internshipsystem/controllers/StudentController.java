package com.backend.internshipsystem.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studant")
public class StudentController {
	@GetMapping
	public ResponseEntity getAllStudants() {
		return ResponseEntity.ok("Deu Certo!");
	}
}
