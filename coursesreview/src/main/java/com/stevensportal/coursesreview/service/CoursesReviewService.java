package com.stevensportal.coursesreview.service;

import java.util.List;

import com.stevensportal.coursesreview.contract.response.CoursesResponseDTO;
import com.stevensportal.coursesreview.contract.response.LoginResponseDTO;
import com.stevensportal.coursesreview.contract.response.ProfessorResponseDTO;
import com.stevensportal.coursesreview.contract.response.ReviewsResponseDTO;
import com.stevensportal.coursesreview.contract.response.StudentResponseDTO;
import com.stevensportal.coursesreview.contract.response.base.ErrorDTO;

/**
 * @author staneja14
 *
 */
public interface CoursesReviewService {

	/**
	 * 
	 * @param emailId
	 * @param errorList TODO
	 * @return
	 */
	LoginResponseDTO verifyUser(String emailId, List<ErrorDTO> errorList);

	/**
	 * 
	 * @param studentId
	 * @param errorList
	 * @return
	 */
	StudentResponseDTO fetchStudentInfo(Integer studentId, List<ErrorDTO> errorList);

	/**
	 * 
	 * @param studentId
	 * @param errorList
	 * @return
	 */
	CoursesResponseDTO fetchCoursesInfo(Integer studentId, List<ErrorDTO> errorList);

	/**
	 * 
	 * @param courseId
	 * @param errorList
	 * @return
	 */
	ProfessorResponseDTO fetchProfessorInfo(Integer courseId, List<ErrorDTO> errorList);
	

	/**
	 * 
	 * @param courseId
	 * @param errorList
	 * @return
	 */
	ReviewsResponseDTO fetchReviews(Integer courseId, List<ErrorDTO> errorList);

	/**
	 * 
	 * @param studentId
	 * @param courseId
	 * @param description
	 * @param errorList
	 */
	void postTheReview(int studentId, int courseId, String description, List<ErrorDTO> errorList);

	
}
