package com.idat.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.edu.model.Course;
import com.idat.edu.service.ICourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	ICourseService dao;
	
	@GetMapping
	public ResponseEntity<List<Course>> findCourses(){
		List<Course> courses = dao.findAll();
		if(!courses.isEmpty() && courses != null) {
			return ResponseEntity.status(HttpStatus.OK).body(	courses	);
		}else {
			return ResponseEntity.status(505).build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Course> findCourseById(@PathVariable("id")Integer id ){
		Course course = dao.findById(id);
		if(course.getId_course() > 0 && course.getId_course() != null) {
			return ResponseEntity.status(HttpStatus.OK).body(	course	);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/exists/{id}")
	public ResponseEntity<Boolean> existCourseById(@PathVariable("id") Integer id) {
		return ResponseEntity.status(HttpStatus.OK) 
				.body( dao.existsById(id) );
	}
	
	@PostMapping
	public ResponseEntity<Course> saveNewCourse(@RequestBody Course course){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(	dao.save(course)	);
	}
	
	@PutMapping
	public ResponseEntity<Course> saveCourse(@RequestBody Course course){
		if(dao.existsById(	course.getId_course()	)) {
			return ResponseEntity.status(HttpStatus.OK).body(	dao.update(course)	);
		}else{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id")Integer id){
		if(dao.existsById(id)) {
			dao.deletebyId(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
}
