package com.idat.edu.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.edu.model.Career;
import com.idat.edu.repository.ICareerRepository;
import com.idat.edu.service.ICareerService;

@Service
@Transactional
public class CareerServiceImpl implements ICareerService{

	@Autowired
	ICareerRepository dao;
	
	@Override
	public List<Career> findAll() {
		return (List<Career>) dao.findAll();
	}

	@Override
	public Career findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public Career save(Career model) {
		return dao.save(model);
	}

	@Override
	public Career update(Career model) {
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
