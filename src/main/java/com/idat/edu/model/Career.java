package com.idat.edu.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Career implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8894184376552593894L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_career;
	
	@Column(nullable = false)
	private String name;
	
	private String description;
	
	//@Transient
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "career")
	private List<Student> student;

	
	
	public Career() {}

	public Career(String name, String description) {
		this.name = name;
		this.description = description;
	}

	
	public Career(Integer id_career, String name, String description) {
		super();
		this.id_career = id_career;
		this.name = name;
		this.description = description;
	}

	public Integer getId_career() {
		return id_career;
	}



	public void setId_career(Integer id_career) {
		this.id_career = id_career;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	@Override
	public String toString() {
		return "Career [id_career=" + id_career + ", name=" + name + ", description=" + description ;
	}
	
	


}
