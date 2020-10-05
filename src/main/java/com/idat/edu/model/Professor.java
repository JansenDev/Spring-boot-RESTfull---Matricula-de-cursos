package com.idat.edu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Professor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_professor;
	@Column(nullable = false)
	private String cod_professor;
	@Column(nullable = false)
	private String name;

	private String email;
	
	private String profession;
	
	@JoinColumn(name = "id_course",referencedColumnName = "id_course")
	@OneToOne
	private Course course;
	


	public Professor() {}
	
	public Professor(Integer id_professor, String cod_professor, String name, String email, String profession) {
		super();
		this.id_professor = id_professor;
		this.cod_professor = cod_professor;
		this.name = name;
		this.email = email;
		this.profession = profession;
	}
	
	
	public Integer getId_professor() {
		return id_professor;
	}
	public void setId_professor(Integer id_professor) {
		this.id_professor = id_professor;
	}
	public String getCod_professor() {
		return cod_professor;
	}
	public void setCod_professor(String cod_professor) {
		this.cod_professor = cod_professor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
	
}
