package com.idat.edu.repository;

import org.springframework.data.repository.CrudRepository;

import com.idat.edu.model.Student;

public interface IStudentRepository extends CrudRepository<Student, Integer> {

}
