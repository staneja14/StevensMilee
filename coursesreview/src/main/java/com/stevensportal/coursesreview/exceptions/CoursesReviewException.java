package com.stevensportal.coursesreview.exceptions;

import java.util.List;

import com.stevensportal.coursesreview.contract.response.base.ErrorDTO;

/**
 * @author staneja14
 *
 */
public class CoursesReviewException extends Exception {

	private static final long serialVersionUID = 8834622597690094289L;
	
	private List<ErrorDTO> errors;
	private String errorMessage = null;

	public CoursesReviewException(List<ErrorDTO> errors) {
		super();
		this.errors = errors;
	}
	
	public CoursesReviewException(List<ErrorDTO> errors, String errorMessage) {
		super();
		this.errors = errors;
		this.errorMessage = errorMessage;
	}
	
	/**
	 * A public constructor for CoursesReviewException containing no arguments.
	 */
	public CoursesReviewException() {
	}

	/**
	 * A public constructor for CoursesReviewException containing exception message
	 * 
	 * @param message
	 */
	public CoursesReviewException(String message) {
		super(message);
		this.errorMessage = message;
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CoursesReviewException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CoursesReviewException(Exception e) {
		super(e);
		if (e instanceof InputValidationException) {
			this.errors = ((InputValidationException) e).getErrors();
		}
	}

	/**
	 * @return the errors
	 */
	public List<ErrorDTO> getErrors() {
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<ErrorDTO> errors) {
		this.errors = errors;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "CoursesReviewException [errors=" + errors + ", errorMessage=" + errorMessage + "]";
	}
	
}
