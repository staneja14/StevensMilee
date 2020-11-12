package com.stevensportal.coursesreview.constant;

/**
 * @author staneja14
 *
 */
public interface UrlConstants {
	
	String CONTROLLER_URL = "/api/v1";
	String LOGIN_URL = "/login";
	String STUDENT_URL = "/{studentId}/info"; 
	String COURSES_URL = "/{studentId}/courses";
	String PROFESSOR_URL = "/{courseId}/professor";
	
}
