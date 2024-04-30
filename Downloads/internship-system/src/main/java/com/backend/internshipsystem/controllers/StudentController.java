package com.backend.internshipsystem.controllers;
import com.backend.internshipsystem.domain.RequestStudentDTO;
import com.backend.internshipsystem.domain.RequestStudentPutDTO;
import com.backend.internshipsystem.domain.entities.Student;
import com.backend.internshipsystem.domain.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


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
	public ResponseEntity  updateStudent(@RequestBody @Valid RequestStudentPutDTO data){
		Optional<Student> student = repository.findById(data.id());
		if(student.isPresent()){
			student.get().setEmail(data.email());
			student.get().setSenha(data.senha());
			return ResponseEntity.ok(student);
		}else{
			throw new EntityNotFoundException();
		}
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity deleteStudent(@PathVariable String id){
		Optional<Student> student = repository.findById(id);
		if(student.isPresent()){
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		}else{
			throw new EntityNotFoundException();
		}
	}

}
