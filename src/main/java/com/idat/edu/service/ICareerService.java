package com.idat.edu.service;

import java.util.List;

import com.idat.edu.model.Career;

public interface ICareerService {
	
	List<Career> findAll();
	
	Career findById(Integer id);
	
	Career save(Career model);
	
	Career update(Career model);
	
	void deletebyId(Integer id);
	
	boolean existsById(Integer id);
	
}
