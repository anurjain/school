package com.aj.restapi.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aj.restapi.school.dto.StudentDto;
import com.aj.restapi.school.service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	
	@Autowired
	StudentService service;

	@GetMapping
	public List <StudentDto> getStudents () {
		return service.findAllStudents();
	}
	
	@GetMapping("/{id}")
	public StudentDto getStudent (@PathVariable Integer id) {
		//Integer idx = id.intValue();
		return service.findById(id);
	}
	
	@PostMapping
	public void createStudent (@RequestBody StudentDto student) {
		service.createStudent(student);
	}
	
	@PutMapping("/{id}")
	public void updateStudent (@PathVariable Integer id, @RequestBody StudentDto student) {
		service.updateStudent(student);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent (@PathVariable Integer id) {
		service.deleteStudent (id);
	}
}
