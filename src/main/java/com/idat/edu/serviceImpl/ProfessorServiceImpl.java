package com.idat.edu.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.edu.model.Professor;
import com.idat.edu.repository.IProfessorRepository;
import com.idat.edu.service.IProfessorService;

@Service
@Transactional
public class ProfessorServiceImpl implements IProfessorService{

	@Autowired
	IProfessorRepository dao;
	
	@Override
	public List<Professor> findAll() {
		return (List<Professor>) dao.findAll();
	}

	@Override
	public Professor findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public Professor save(Professor model) {
		return dao.save(model);
	}

	@Override
	public Professor update(Professor model) {
		return dao.save(model);
	}

	@Override		
	public void deletebyId(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return dao.existsById(id);
	}


}
