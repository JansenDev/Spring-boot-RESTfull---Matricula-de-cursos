package com.idat.edu.repository;

import org.springframework.data.repository.CrudRepository;

import com.idat.edu.model.Professor;

public interface IProfessorRepository extends CrudRepository<Professor, Integer> {

}
