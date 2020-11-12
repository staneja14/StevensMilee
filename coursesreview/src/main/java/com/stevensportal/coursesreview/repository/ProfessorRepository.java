/**
 * 
 */
package com.stevensportal.coursesreview.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stevensportal.coursesreview.entity.Professor;

/**
 * @author staneja14
 *
 */
@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Integer> {

}
