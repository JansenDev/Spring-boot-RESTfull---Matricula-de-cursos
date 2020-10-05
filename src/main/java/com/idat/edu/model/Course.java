package com.idat.edu.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_course;
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Integer credits;
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students;

	@OneToOne(mappedBy = "course")
	private Professor professor;
	
	
	
	public Course() {}
	
	
	public Course(Integer id_course, String name, Integer credits) {
		super();
		this.id_course = id_course;
		this.name = name;
		this.credits = credits;
	}

	public Integer getId_course() {
		return id_course;
	}

	public void setId_course(Integer id) {
		this.id_course = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}


	public Professor getProfessor() {
		return professor;
	}




	
	
}
