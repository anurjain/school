package com.aj.restapi.school.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table (name="result")
@JsonIgnoreProperties({"hibbernateLazyInitialzer","handler"})
public class Result implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column (name="id")
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator="result_id_gen")
	@SequenceGenerator(name="result_id_gen", sequenceName = "result_seq", initialValue = 1, allocationSize=1)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@Column(name="grade")
	private String grade;
	
	@Column(name="score")
	private Integer score;
	
	@OneToOne
	@JoinColumn(name = "subject_id", updatable=false)
	private Subject subject;

	@Version
	private Long version;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the score
	 */
	public Integer getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

	/**
	 * @return the subject
	 */
	public Subject getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	/**
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Long version) {
		this.version = version;
	}
}
