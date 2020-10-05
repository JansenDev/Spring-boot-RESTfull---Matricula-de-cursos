package com.idat.edu.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.edu.model.Student;
import com.idat.edu.repository.IStudentRepository;
import com.idat.edu.service.IStudentService;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

	@Autowired
	IStudentRepository dao;
	
	@Override
	public List<Student> findAll() {
		return (List<Student>) dao.findAll();
	}

	@Override
	public Student findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public Student save(Student model) {
		return dao.save(model);
	}

	@Override
	public Student update(Student model) {
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
