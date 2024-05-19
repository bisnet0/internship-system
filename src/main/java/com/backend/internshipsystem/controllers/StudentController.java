package com.backend.internshipsystem.controllers;
import com.backend.internshipsystem.domain.dto.RequestStudentDTO;
import com.backend.internshipsystem.domain.entities.Student;
import com.backend.internshipsystem.domain.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentRepository repository;
	@GetMapping
	public ResponseEntity getAllStudants() {
		var allStudents = repository.findAll();
		return ResponseEntity.ok(allStudents);
	}

	@PostMapping
	public ResponseEntity registerStudent(@RequestBody @Valid RequestStudentDTO data){
		Student student = new Student(data);
		System.out.println(data);
		repository.save(student);
		return ResponseEntity.ok().build();
	}

	@PutMapping
	@Transactional
	public ResponseEntity  updateStudent(@RequestBody @Valid RequestStudentDTO data){
		Optional<Student> student = repository.findById(UUID.fromString(data.id()));
		if(student.isPresent()){
			student.get().setNome(data.nome());
			student.get().setEmail(data.email());
			student.get().setMatricula(data.matricula());
			student.get().setData_nascimento(data.data_nascimento());
			return ResponseEntity.ok(student);
		}else{
			throw new EntityNotFoundException();
		}
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity deleteStudent(@PathVariable UUID id){
		Optional<Student> student = repository.findById(id);
		if(student.isPresent()){
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		}else{
			throw new EntityNotFoundException();
		}
	}

}
