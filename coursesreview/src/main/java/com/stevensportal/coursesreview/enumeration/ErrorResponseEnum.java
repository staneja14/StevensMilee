package com.stevensportal.coursesreview.enumeration;

/**
 * @author staneja14
 *
 */
public enum ErrorResponseEnum {
	
	EMAIL_ID_IS_MISSING("EMAIL_ID_IS_MISSING", "Email id is missing"),
	EMAIL_ID_IS_INVALID("EMAIL_ID_IS_INVALID", "Email id is invalid"),
	EMAIL_DOES_NOT_EXIST("EMAIL_DOES_NOT_EXIST", "Email id does not exist"),
	STUDENT_DOES_NOT_EXIST("STUDENT_DOES_NOT_EXIST", "Student does not exist"),
	COURSE_DOES_NOT_EXIST("COURSE_DOES_NOT_EXIST", "Course does not exist");
	
	private final String responseCode;
	private final String responseMessage;
	
	/**
	 * @param responseCode
	 * @param responseMessage
	 */
	private ErrorResponseEnum(String responseCode, String responseMessage) {
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

	/**
	 * @return the responseCode
	 */
	public String getErrorCode() {
		return this.responseCode;
	}

	/**
	 * @return the responseMessage
	 */
	public String getErrorMessage() {
		return this.responseMessage;
	}
	
}
