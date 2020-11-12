package com.stevensportal.coursesreview.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stevensportal.coursesreview.entity.Student;

/**
 * @author staneja14
 *
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
	
}
