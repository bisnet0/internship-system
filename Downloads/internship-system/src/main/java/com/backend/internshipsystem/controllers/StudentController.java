package com.backend.internshipsystem.controllers;
import com.backend.internshipsystem.domain.RequestStudentDTO;
import com.backend.internshipsystem.domain.Student;
import com.backend.internshipsystem.domain.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


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
	public ResponseEntity registerStudent(@RequestBody @Validated RequestStudentDTO data){
		Student student = new Student(data);
		System.out.println(data);
		repository.save(student);
		return ResponseEntity.ok().build();
	}
}
