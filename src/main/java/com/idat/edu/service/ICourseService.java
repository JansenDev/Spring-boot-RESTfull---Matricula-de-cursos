package com.idat.edu.service;

import java.util.List;

import com.idat.edu.model.Course;

public interface ICourseService {

List<Course> findAll();
	
	Course findById(Integer id);
	
	Course save(Course model);
	
	Course update(Course model);
	
	void deletebyId(Integer id);
	
	boolean existsById(Integer id);
}
