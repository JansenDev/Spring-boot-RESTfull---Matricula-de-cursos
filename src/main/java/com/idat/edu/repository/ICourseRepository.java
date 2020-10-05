package com.idat.edu.repository;

import org.springframework.data.repository.CrudRepository;

import com.idat.edu.model.Course;

public interface ICourseRepository extends CrudRepository<Course,Integer> {

}
