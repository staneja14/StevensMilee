package com.stevensportal.coursesreview.contract.response.base;

import com.stevensportal.coursesreview.enumeration.ErrorResponseEnum;

/**
 * @author staneja14
 *
 */
public class ErrorDTO {
	
	private String errorCode;
	private String message;
	private String attributeCode;
	
	public ErrorDTO() {
	}

	/**
	 * @param errorCode
	 * @param message
	 * @param attributeCode
	 */
	public ErrorDTO(String errorCode, String message, String attributeCode) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.attributeCode = attributeCode;
	}
	
	/**
	 * @param errorEnum
	 * @param attributeCode
	 */
	public ErrorDTO(ErrorResponseEnum errorEnum, String attributeCode) {
		super();
		this.errorCode = errorEnum.getErrorCode();
		this.message = errorEnum.getErrorMessage();
		this.attributeCode = attributeCode;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the attributeCode
	 */
	public String getAttributeCode() {
		return attributeCode;
	}

	/**
	 * @param attributeCode the attributeCode to set
	 */
	public void setAttributeCode(String attributeCode) {
		this.attributeCode = attributeCode;
	}
	
}
