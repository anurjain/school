package com.aj.restapi.school.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aj.restapi.school.dto.StudentDto;


public interface StudentService {

	public List<StudentDto> findAllStudents();

	public StudentDto findById(Integer id);

	public void createStudent(StudentDto dto);

	public void updateStudent(StudentDto dto);

	public void deleteStudent(Integer id);
}
