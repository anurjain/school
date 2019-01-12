package com.aj.restapi.school.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.aj.restapi.school.dto.StudentDto;
import com.aj.restapi.school.mapper.StudentMapper;
import com.aj.restapi.school.model.Student;
import com.aj.restapi.school.repository.StudentRepository;
import com.aj.restapi.school.service.StudentService;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {
	
	@Mock
	StudentRepository studentRepo;
	@Mock
	StudentMapper mapper ; 
	
	@InjectMocks
	StudentServiceImpl service;
	
	List<Student> students;
	
	@BeforeEach
	public void setUp () {
		
		MockitoAnnotations.initMocks(this);
		students = new ArrayList <Student> ();
		//Given
		Student student1 = new Student ();
		student1.setId(1);
		student1.setFirstName("Virat");
		student1.setLastName("Kohli");
		student1.setVersion(0l);
		
		Student student2 = new Student ();
		student2.setId(1);
		student2.setFirstName("Rohit");
		student2.setLastName("Sharma");
		student2.setVersion(0l);
		
		students.add(student1);
		students.add(student2);
	}
	
	@Test
	void findAllStudentsTest() {
		//Given
		StudentDto dto = new StudentDto();
		dto.setFullName("Virat Kohli");
		//When
		Mockito.when(studentRepo.findAll()).thenReturn(students);

		Mockito.when(mapper.studentToStudentDto(Mockito.any())).thenReturn(dto);
		//Then
		List<StudentDto> dtoList = service.findAllStudents();
		
		dtoList.forEach(a -> System.out.println(a.getFullName()));
	}
}
