package com.aj.restapi.school.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aj.restapi.school.dto.ResultDto;
import com.aj.restapi.school.mapper.ResultMapper;
import com.aj.restapi.school.model.Result;
import com.aj.restapi.school.model.Student;
import com.aj.restapi.school.model.Subject;
import com.aj.restapi.school.repository.ResultRepository;
import com.aj.restapi.school.repository.StudentRepository;
import com.aj.restapi.school.repository.SubjectRepository;
import com.aj.restapi.school.service.ResultService;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	ResultRepository resultRepo;

	@Autowired
	ResultMapper mapper ;
	
	@Autowired
	StudentRepository studRepo;
	
	@Autowired
	SubjectRepository subRepo;

	public JpaRepository<Result, Integer> getRepository() {
		return resultRepo;
	}

	public ResultMapper getMapper() {
		return mapper;
	}

	@Transactional(readOnly = true )
	
	public List<ResultDto> findAllResults() {
		List<ResultDto> resultList = new ArrayList<>();
		resultList = getRepository().findAll().stream().map(a -> getMapper().resultToResultDto(a))
				.collect(Collectors.toList());
		return resultList;
	}

	@Transactional(readOnly = true )
	
	public ResultDto findById(Integer id) {
		Optional<Result> option = getRepository().findById(id);
		if (option.isPresent())
			return getMapper().resultToResultDto((Result) option.get());
		else
			return null;
	}

	@Transactional
	
	public void createResult(ResultDto dto) {
		Result entity = new Result ();
		entity.setGrade(dto.getGrade());
		entity.setScore(dto.getScore());
		Student student = studRepo.findById(dto.getStudentId()).get();
		student.setId(dto.getStudentId());
		
		entity.setStudent(student);
		
		Subject subject = subRepo.findById(dto.getSubjectId()).get();
		subject.setId(dto.getSubjectId());
		
		entity.setSubject(subject);
		getRepository().save(entity);
		
	}

	@Transactional
	
	public void updateResult(ResultDto dto) {
		Optional<Result> option = getRepository().findById(dto.getId());
		if (option.isPresent()) {
			Result entity = getMapper().resultDtoToResult(dto);
			getRepository().save(entity);
		}

	}

	@Transactional
	
	public void deleteResult(Integer id) {
		Result student = getRepository().getOne(id);
		getRepository().delete(student);
	}

}
