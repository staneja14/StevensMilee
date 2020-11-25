package com.stevensportal.coursesreview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stevensportal.coursesreview.entity.Comment;

/**
 * @author staneja14
 *
 */
@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
	
	@Query("select c from Comment c where c.courseId = :courseId")
	List<Comment> findReviewsByCourseId(@Param("courseId") int courseId);

}
