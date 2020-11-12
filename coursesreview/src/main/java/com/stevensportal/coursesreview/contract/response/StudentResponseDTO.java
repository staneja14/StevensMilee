package com.stevensportal.coursesreview.contract.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author staneja14
 *
 */
@ApiModel(description = "Details about the Student Response")
@JsonInclude(Include.NON_NULL)
public class StudentResponseDTO {

	@ApiModelProperty(notes = "Unique id of the student")
	private int studentId;
	
	@ApiModelProperty(notes = "Name of the student")
	private String name;
	
	@ApiModelProperty(notes = "Email Id of the student")
	private String emailId;
	
	@ApiModelProperty(notes = "Major of the student")
	private String major;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "StudentResponseDTO [studentId=" + studentId + ", name=" + name + ", emailId=" + emailId + ", major="
				+ major + "]";
	}
	
}
