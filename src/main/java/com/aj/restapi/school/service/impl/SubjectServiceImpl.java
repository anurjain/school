package com.aj.restapi.school.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aj.restapi.school.dto.SubjectDto;
import com.aj.restapi.school.mapper.SubjectMapper;
import com.aj.restapi.school.model.Subject;
import com.aj.restapi.school.repository.SubjectRepository;
import com.aj.restapi.school.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	SubjectRepository subjectRepo;

	@Autowired
	SubjectMapper mapper;
	
	@Transactional(readOnly = true )
	public List<SubjectDto> findAllSubjects() {
		List<SubjectDto> results =  getRepository().findAll().stream().map(a -> getMapper().subjectToSubjectDto(a))
				.collect(Collectors.toList());
		
		System.out.println("Resutls Count "+results.size());
		return results;
	}

	@Transactional(readOnly = true )
	public SubjectDto findById(Integer id) {
		Optional<Subject> option = getRepository().findById(id); 	
		if (option.isPresent())
			return getMapper().subjectToSubjectDto((Subject)option.get());
		else
			return null;
	}

	public JpaRepository<Subject, Integer> getRepository () {
		return subjectRepo;
	}
	
	public SubjectMapper getMapper () {
		return mapper;
	}
}
