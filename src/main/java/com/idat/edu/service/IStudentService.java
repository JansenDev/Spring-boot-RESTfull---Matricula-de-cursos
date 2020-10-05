package com.idat.edu.service;

import java.util.List;

import com.idat.edu.model.Student;

public interface IStudentService {
	
	List<Student> findAll();

	Student findById(Integer id);

	Student save(Student model);

	Student update(Student model);

	void deletebyId(Integer id);
	
	boolean existsById(Integer id);
}
