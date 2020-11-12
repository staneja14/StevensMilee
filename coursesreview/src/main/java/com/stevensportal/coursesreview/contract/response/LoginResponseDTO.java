package com.stevensportal.coursesreview.contract.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author staneja14
 *
 */
@ApiModel(description = "Details about the LoginResponse")
@JsonInclude(Include.NON_NULL)
public class LoginResponseDTO {
	
	@ApiModelProperty(notes = "Unique id of the logged in user")
	private int studentId;

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

	@Override
	public String toString() {
		return "LoginResponseDTO [studentId=" + studentId + "]";
	}
	
}
