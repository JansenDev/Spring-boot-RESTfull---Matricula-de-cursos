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

import com.idat.edu.model.Career;
import com.idat.edu.service.ICareerService;

@RestController
@RequestMapping("/career")
public class CareerController {
	
	@Autowired
	ICareerService dao;
	
	@GetMapping
	public ResponseEntity<List<Career>> findCareers(){
		
		List<Career> careers = dao.findAll();
		
		if( !careers.isEmpty() && careers != null ) {
			return ResponseEntity.status(HttpStatus.OK).body(	careers	);
		}else {
			return ResponseEntity.status(505).build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Career> findByIdCareer(@PathVariable("id") Integer id){
		
		Career career = dao.findById(id);
		
		if( career.getId_career() > 0 && career.getId_career() != null ) {
			return ResponseEntity.status(HttpStatus.OK).body( career  );
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/exists/{id}")
	public ResponseEntity<Boolean> existsCareer(@PathVariable("id") Integer id){
		return ResponseEntity.status(HttpStatus.OK)
				.body(  dao.existsById(id)  );
	}

	@PostMapping
	public ResponseEntity<Career> saveNewCareer(@RequestBody Career career) {
		Career carrera = dao.save(career);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(	carrera	);
	}
	
	@PutMapping
	public ResponseEntity<Career> updateCareer(@RequestBody Career career) {
		if(dao.existsById(	career.getId_career()	)) {
			return ResponseEntity.status(HttpStatus.OK).body(	dao.save(career)	);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); 
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id){
		
		if( dao.existsById(id) ) {
				dao.deletebyId(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	

}
