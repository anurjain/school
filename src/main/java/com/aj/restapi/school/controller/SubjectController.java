package com.aj.restapi.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aj.restapi.school.dto.SubjectDto;
import com.aj.restapi.school.service.SubjectService;

@RestController
@RequestMapping("/api/v1/subjects")
public class SubjectController {

		
	private SubjectService service;
	
	@Autowired
	public SubjectController (SubjectService service) {
		this.service = service;
	}
	
	@GetMapping

	public List <SubjectDto> getSubjects () {
		List <SubjectDto> results =  service.findAllSubjects();
		System.out.println("Results @@@@@@@@@@@@@@@@@@@@@@" + results);
		results.forEach(a-> System.out.println(a));
		return results	;
	}

	
	@GetMapping("/{id}")
	public SubjectDto getSubject (@PathVariable Integer id) {
		//Integer idx = id.intValue();
		return service.findById(id);
	}
}


