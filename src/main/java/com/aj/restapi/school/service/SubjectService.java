package com.aj.restapi.school.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aj.restapi.school.dto.SubjectDto;
import com.aj.restapi.school.model.Subject;

public interface SubjectService {

	public List<SubjectDto> findAllSubjects();

	public SubjectDto findById(Integer id);
}
