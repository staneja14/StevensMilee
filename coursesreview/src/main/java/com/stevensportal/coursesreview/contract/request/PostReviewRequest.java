package com.stevensportal.coursesreview.contract.request;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author staneja14
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostReviewRequest {
	
	private int studentId;
	
	private int courseId;
	
	@NotEmpty(message = "description must not be empty")
	private String description;

	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "PostReviewRequest [studentId=" + studentId + ", courseId=" + courseId + ", description=" + description
				+ "]";
	}
	
}
