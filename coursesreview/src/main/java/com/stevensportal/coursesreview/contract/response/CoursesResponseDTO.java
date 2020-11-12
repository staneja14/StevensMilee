package com.stevensportal.coursesreview.contract.response;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author staneja14
 *
 */
@ApiModel(description = "Details about the CoursesResponse")
@JsonInclude(Include.NON_NULL)
public class CoursesResponseDTO {

	@ApiModelProperty(notes = "Details about the courses of a student")
	List<CourseResponseDTO> courses;

	/**
	 * @return the courses
	 */
	public List<CourseResponseDTO> getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(List<CourseResponseDTO> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "CoursesResponseDTO [courses=" + courses + "]";
	}
	
}
