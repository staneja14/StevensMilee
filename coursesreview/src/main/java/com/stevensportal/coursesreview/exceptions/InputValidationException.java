package com.stevensportal.coursesreview.exceptions;

import java.util.List;

import com.stevensportal.coursesreview.contract.response.base.ErrorDTO;

/**
 * @author staneja14
 *
 */
public class InputValidationException extends Exception {

	private static final long serialVersionUID = -6197992395827381291L;

	private List<ErrorDTO> errors;
	
	public InputValidationException() {
	}

	/**
	 * @param message
	 */
	public InputValidationException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InputValidationException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InputValidationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public InputValidationException(List<ErrorDTO> errors) {
		super();
		this.errors = errors;
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

	@Override
	public String toString() {
		return "InputValidationException [errors=" + errors + "]";
	}
}
