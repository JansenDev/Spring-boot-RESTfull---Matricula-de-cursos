package com.idat.edu.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;

import com.idat.edu.model.Student;
import com.idat.edu.service.IStudentService;

@RestController
public class StudentController {

	@Autowired
	IStudentService dao;

	@GetMapping
	public ResponseEntity<List<Student>> findStudents() {
		try {

			List<Student> students = dao.findAll();

			if (!students.isEmpty() && students != null) {
				return ResponseEntity.status(HttpStatus.OK).body(students);
			} else {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body( new ArrayList<Student>() );
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> findStudent(@PathVariable("id") Integer id) {

		try {
			Student student = dao.findById(id);

			if (student.getId() != null && student.getId() > 0) {
				return ResponseEntity.status(HttpStatus.OK).body(student);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Student());
		}

	}

	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {

		Student newStudent = dao.save(student);
		try {

			if (newStudent.getId() != null && newStudent.getId() > 0) {
				return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	@PutMapping
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {

		try {
			Student updateStudent = dao.update(student);

			if (student.getId() != null && student.getId() > 0) {
				return ResponseEntity.status(HttpStatus.OK).body(updateStudent);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer id) {

		try {

			if (dao.existsById(id)) {
				return ResponseEntity.status(HttpStatus.OK).build();
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

}
