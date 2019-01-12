package com.aj.restapi.school.dto;


public class ResultDto {
	private Integer id;

	private Integer studentId;
	
	private String studentFirstName;
	
	private String studentLastName;

	private String grade;
	
	private Integer score;
	
	private Integer subjectId;
	
	private String subjectName;

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
	 * @return the studentFirstName
	 */
	public String getStudentFirstName() {
		return studentFirstName;
	}

	/**
	 * @param studentFirstName the studentFirstName to set
	 */
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	/**
	 * @return the studentLastName
	 */
	public String getStudentLastName() {
		return studentLastName;
	}

	/**
	 * @param studentLastName the studentLastName to set
	 */
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
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
	 * @return the subjectName
	 */
	public String getSubjectName() {
		return subjectName;
	}

	/**
	 * @param subjectName the subjectName to set
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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

	/**
	 * @return the studentId
	 */
	public Integer getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the subjectId
	 */
	public Integer getSubjectId() {
		return subjectId;
	}

	/**
	 * @param subjectId the subjectId to set
	 */
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}	
}
