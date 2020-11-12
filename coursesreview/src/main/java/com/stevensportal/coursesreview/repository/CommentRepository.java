package com.stevensportal.coursesreview.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stevensportal.coursesreview.entity.Comment;

/**
 * @author staneja14
 *
 */
@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
