package com.stevensportal.coursesreview.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stevensportal.coursesreview.entity.Course;
import com.stevensportal.coursesreview.contract.response.CourseProfessorMappingDTO;
import com.stevensportal.coursesreview.contract.response.StudentMajorCourseMappingDTO;

import java.util.*;

/**
 * @author staneja14
 *
 */
@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

	@Query("select new com.stevensportal.coursesreview.contract.response.StudentMajorCourseMappingDTO(s, m, c) from Student s, Major m, Course c where s.studentId = :studentId and s.majorId = m.majorId and m.majorId = c.majorId")
	List<StudentMajorCourseMappingDTO> findCoursesByStudentId(@Param("studentId") int studentId);

	@Query("select new com.stevensportal.coursesreview.contract.response.CourseProfessorMappingDTO(c, p) from Course c, Professor p where c.courseId = :courseId and c.profId = p.profId")
	List<CourseProfessorMappingDTO> findProfessorByCourseId(@Param("courseId") int courseId);
}
