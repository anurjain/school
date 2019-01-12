package com.aj.restapi.school.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.aj.restapi.school.dto.StudentDto;
import com.aj.restapi.school.model.Student;


@Mapper(componentModel="spring")
public interface StudentMapper{
	
	StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

	@Mappings({
		@Mapping (expression = "java(entity.getFullName())", target="fullName"),
		@Mapping(source="entity.id", target="id"),
		@Mapping (source="version", target ="version")
	})
	public  StudentDto studentToStudentDto (Student entity);
	
	@Mappings({
		@Mapping (expression = "java(dto.getFullName().substring (0, dto.getFullName().indexOf(' ')))", target="firstName"),
		@Mapping (expression = "java(dto.getFullName().substring (dto.getFullName().indexOf(' ')+1, dto.getFullName().length()))", target="lastName"),
		@Mapping (source="id", target ="id"),
		@Mapping (source="version", target ="version")
	})
	public Student studentDtoToStudent (StudentDto dto);
	
}
