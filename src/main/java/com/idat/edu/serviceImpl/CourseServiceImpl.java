package com.idat.edu.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.edu.model.Course;
import com.idat.edu.repository.ICourseRepository;
import com.idat.edu.service.ICourseService;

@Service
@Transactional
public class CourseServiceImpl implements ICourseService{

	@Autowired
	ICourseRepository dao;
	
	@Override
	public List<Course> findAll() {
		return (List<Course>) dao.findAll();
	}

	@Override
	public Course findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public Course save(Course model) {
		return dao.save(model);
	}

	@Override
	public Course update(Course model) {
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
