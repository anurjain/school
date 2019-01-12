package com.aj.restapi.school.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aj.restapi.school.dto.StudentDto;
import com.aj.restapi.school.mapper.StudentMapper;
import com.aj.restapi.school.model.Student;
import com.aj.restapi.school.repository.StudentRepository;
import com.aj.restapi.school.service.StudentService;

@Service
public class StudentServiceImpl  implements StudentService{

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	StudentMapper mapper;

	@Transactional(readOnly = true )
	
	public List<StudentDto> findAllStudents() {
		List<StudentDto> studentList = new ArrayList<>();

		studentList = getRepository().findAll().stream().map(a -> getMapper().studentToStudentDto(a))
				.collect(Collectors.toList());
		return studentList;
	}

	@Transactional(readOnly = true )
	
	public StudentDto findById (Integer id) {
		
		Optional<Student> option = getRepository().findById(id); 	
		if (option.isPresent())
			return getMapper().studentToStudentDto((Student)option.get());
		else
			return null;
	}
	
	@Transactional
	
	public void createStudent (StudentDto dto) {
		Student entity = getMapper().studentDtoToStudent(dto); 
		getRepository().save(entity);
	}
	
	@Transactional
	
	public void updateStudent (StudentDto dto) {
		Optional<Student> option = getRepository().findById(dto.getId()); 	
		if (option.isPresent())
		{
			Student entity = getMapper().studentDtoToStudent(dto);
			getRepository().save(entity);
		}		
	}
	
	@Transactional
	
	public void deleteStudent (Integer id) {
		Student student = getRepository().getOne(id);
		getRepository().delete(student);
	}
	
	public JpaRepository<Student, Integer> getRepository () {
		return studentRepo;
	}
	
	public StudentMapper getMapper () {
		return mapper;
	}
}
