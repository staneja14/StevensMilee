package com.stevensportal.coursesreview.contract.response;

import com.stevensportal.coursesreview.entity.Course;
import com.stevensportal.coursesreview.entity.Major;
import com.stevensportal.coursesreview.entity.Student;

/**
 * @author staneja14
 *
 */
public class StudentMajorCourseMappingDTO {
	
	private Student student;
	private Major major;
	private Course course;
	
	/**
	 * @param student
	 * @param major
	 * @param course
	 */
	public StudentMajorCourseMappingDTO(Student student, Major major, Course course) {
		super();
		this.student = student;
		this.major = major;
		this.course = course;
	}
	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}
	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	/**
	 * @return the major
	 */
	public Major getMajor() {
		return major;
	}
	/**
	 * @param major the major to set
	 */
	public void setMajor(Major major) {
		this.major = major;
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
	@Override
	public String toString() {
		return "StudentMajorCourseMappingDTO [student=" + student + ", major=" + major + ", course=" + course + "]";
	}
}
