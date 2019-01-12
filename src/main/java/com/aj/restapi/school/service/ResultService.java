package com.aj.restapi.school.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aj.restapi.school.dto.ResultDto;

public interface ResultService {

	public List<ResultDto> findAllResults();

	public ResultDto findById(Integer id);

	public void createResult(ResultDto dto);

	public void updateResult(ResultDto dto);

	public void deleteResult(Integer id);
}
