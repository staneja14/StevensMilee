package com.stevensportal.coursesreview.contract.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author staneja14
 *
 */
@ApiModel(description = "Details about the ReviewResponse")
@JsonInclude(Include.NON_NULL)
public class ReviewResponseDTO {

	@ApiModelProperty(notes = "Unique id of the student who posted the review")
	private int studentId;

	@ApiModelProperty(notes = "Review's description")
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
		return "ReviewResponseDTO [studentId=" + studentId + ", description=" + description + "]";
	}
}
