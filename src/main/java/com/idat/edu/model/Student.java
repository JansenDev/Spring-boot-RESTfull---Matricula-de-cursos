package com.idat.edu.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String cod_student;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, length = 8)
	private String dni;
	
	@JoinColumn(name = "id_career",referencedColumnName = "id_career")
	@ManyToOne(optional = false)
	private Career career;

	@JoinTable(name = "courses_of_student",
			joinColumns = {  @JoinColumn(name = "id_student",referencedColumnName = "id")  },
			inverseJoinColumns = { @JoinColumn(name = "id_course",referencedColumnName = "id_course")	}
			)	
	@ManyToMany
	private List<Course> courses;

	
	public Student() {}
	
	public Student(Integer id, String cod_student, String name, String dni, Career career) {
		super();
		this.id = id;
		this.cod_student = cod_student;
		this.name = name;
		this.dni = dni;
		this.career = career;
	}

	public Student(String cod_student, String name, String dni, Career career) {
		this.cod_student = cod_student;
		this.name = name;
		this.dni = dni;
		this.career = career;
	}
	
	public Student(String cod_student, String name, String dni) {
		this.cod_student = cod_student;
		this.name = name;
		this.dni = dni;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCod_student() {
		return cod_student;
	}

	public void setCod_student(String cod_student) {
		this.cod_student = cod_student;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}
	
	
	
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	

	@Override
	public String toString() {
		return "Student [id=" + id + ", cod_student=" + cod_student ;
	}


	
	
	
}
