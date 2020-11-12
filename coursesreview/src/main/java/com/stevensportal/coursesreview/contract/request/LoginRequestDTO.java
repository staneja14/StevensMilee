package com.stevensportal.coursesreview.contract.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author staneja14
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginRequestDTO {
	
	private String emailId;

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

	@Override
	public String toString() {
		return "LoginRequestDTO [emailId=" + emailId + "]";
	}
}
