package com.stevensportal.coursesreview.contract.response;

import com.stevensportal.coursesreview.entity.Course;
import com.stevensportal.coursesreview.entity.Professor;

/**
 * @author staneja14
 *
 */
public class CourseProfessorMappingDTO {

	private Course course;
	
	private Professor professor;

	/**
	 * @param course
	 * @param professor
	 */
	public CourseProfessorMappingDTO(Course course, Professor professor) {
		super();
		this.course = course;
		this.professor = professor;
	}

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * @return the professor
	 */
	public Professor getProfessor() {
		return professor;
	}

	/**
	 * @param professor the professor to set
	 */
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public String toString() {
		return "CourseProfessorMappingDTO [course=" + course + ", professor=" + professor + "]";
	}
}
