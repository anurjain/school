package com.aj.restapi.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aj.restapi.school.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
