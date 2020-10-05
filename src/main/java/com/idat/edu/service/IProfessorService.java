package com.idat.edu.service;

import java.util.List;

import com.idat.edu.model.Professor;

public interface IProfessorService {

	List<Professor> findAll();

	Professor findById(Integer id);

	Professor save(Professor model);

	Professor update(Professor model);

	void deletebyId(Integer id);

	boolean existsById(Integer id);
	
	
}
