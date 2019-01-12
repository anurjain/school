package com.aj.restapi.school.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.aj.restapi.school.dto.SubjectDto;
import com.aj.restapi.school.model.Subject;

@Mapper(componentModel="spring")
public interface SubjectMapper {

	@Mappings({
		@Mapping (source = "entity.id", target="id"),
		@Mapping(source="entity.subjectName", target="subjectName"),
		@Mapping (source="entity.version", target ="version")
	})
	public  SubjectDto subjectToSubjectDto (Subject entity);
	@Mappings({
		@Mapping (source = "dto.id", target="id"),
		@Mapping(source="dto.subjectName", target="subjectName"),
		@Mapping (source="dto.version", target ="version")
	})	
	public Subject subjectDtoToSubject (SubjectDto dto);
}
