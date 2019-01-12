package com.aj.restapi.school.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table (name="subject")
@JsonIgnoreProperties({"hibbernateLazyInitialzer","handler"})

public class Subject implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name ="id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="subject_id_gen")
	@SequenceGenerator(name="subject_id_gen", sequenceName="subject_seq", initialValue = 1, allocationSize=1)
	private Integer id;
	
	@Column(name = "subject_name")
	private String subjectName;

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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
