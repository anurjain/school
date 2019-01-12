package com.aj.restapi.school.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.aj.restapi.school.dto.ResultDto;
import com.aj.restapi.school.model.Result;

@Mapper(componentModel="spring", uses = {StudentMapper.class, SubjectMapper.class})
public interface ResultMapper {

	@Mappings({
		@Mapping (expression = "java(entity.getStudent().getId())", target="studentId"),
		@Mapping (expression = "java(entity.getStudent().getFirstName())", target="studentFirstName"),
		@Mapping (expression = "java(entity.getStudent().getLastName())", target="studentLastName"),
		@Mapping (expression = "java(entity.getSubject().getSubjectName())", target="subjectName"),
		@Mapping (expression = "java(entity.getSubject().getId())", target="subjectId")
	})
	public  ResultDto resultToResultDto (Result entity);
	
	
	public Result resultDtoToResult (ResultDto dto);
	
}
