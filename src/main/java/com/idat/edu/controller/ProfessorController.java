package com.idat.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.edu.model.Professor;
import com.idat.edu.service.IProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
	
	@Autowired
	private IProfessorService dao;
	
	@GetMapping
	public ResponseEntity<List<Professor>> findProfessors(){
		List<Professor> professors = dao.findAll();
		if(!professors.isEmpty() && professors!= null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(	professors  );
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Professor> findProfessorById(@PathVariable("id") Integer id){
		
		Professor professor = dao.findById(id);
		if(professor.getId_professor() > 0 && professor.getId_professor() != null) {
			return ResponseEntity.status(HttpStatus.OK).body(	professor  );
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	public ResponseEntity<Boolean> existsProfessor(Integer id){
		
		return ResponseEntity.status(HttpStatus.OK)
				.body( dao.existsById(id) );
	}
	
	@PostMapping
	public ResponseEntity<Professor> saveProfessor(@RequestBody Professor professor){
		
		try {
			Professor teacher = dao.save(professor);
			return ResponseEntity.status(HttpStatus.CREATED).body( teacher );
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Professor> updateProfessor(@RequestBody Professor professor){
		if(professor.getId_professor() != null && professor.getId_professor()>0) {
			return ResponseEntity.status(HttpStatus.CREATED).body( dao.update(professor) );
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
	}
	
	public ResponseEntity<String> deleteProfessor(Integer id){
		
		if(dao.existsById(id)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	

	
}
