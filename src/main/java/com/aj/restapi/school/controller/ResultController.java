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

import com.aj.restapi.school.dto.ResultDto;
import com.aj.restapi.school.model.Result;
import com.aj.restapi.school.repository.ResultRepository;
import com.aj.restapi.school.service.ResultService;

@RestController
@RequestMapping("/api/v1/results")
public class ResultController {
	
	@Autowired
	ResultService service; 
	@Autowired
	ResultRepository resultRepo;

//	
	@GetMapping
	//public List <Result> getResults () {
	public List <ResultDto> getStudents () {			
		//return resultRepo.findAll();
		return service.findAllResults();
	}
	
	@GetMapping("/{id}")
	public ResultDto getResult (@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@PostMapping
	public void createResult (@RequestBody ResultDto dto) {
		service.createResult(dto);
	}
	
	@PutMapping("/{id}")
	public void updateResult (@PathVariable Integer id, @RequestBody ResultDto dto) {
		service.updateResult(dto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteResult (@PathVariable Integer id) {
		service.deleteResult (id);
	}

}
