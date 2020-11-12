package com.stevensportal.coursesreview.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stevensportal.coursesreview.constant.CoursesReviewConstant;
import com.stevensportal.coursesreview.constant.UrlConstants;
import com.stevensportal.coursesreview.contract.response.CoursesResponseDTO;
import com.stevensportal.coursesreview.contract.response.StudentResponseDTO;
import com.stevensportal.coursesreview.contract.response.base.ErrorDTO;
import com.stevensportal.coursesreview.contract.response.base.ResponseDTO;
import com.stevensportal.coursesreview.service.CoursesReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author staneja14
 *
 */
@Api(value = "Student's API", description = "[All Student related APIs]")
@RestController
@RequestMapping(UrlConstants.CONTROLLER_URL)
public class StudentController {
	
	@Autowired
	CoursesReviewService coursesReviewService;

	
	@ApiOperation(value = "Get student info based on the Id", notes = "Provide the student info, whose id has been passed in the request url, if it exists in the database", response = ResponseDTO.class)
	@GetMapping(value = UrlConstants.STUDENT_URL, produces = "application/json")
	public ResponseDTO<StudentResponseDTO> getStudentInfo(
			@ApiParam(value = "ID of the student whose info you need to retrieve", required = true) @PathVariable("studentId") Integer studentId) {

		ResponseDTO<StudentResponseDTO> responseBody = new ResponseDTO<>();

		List<ErrorDTO> errorList = new ArrayList<>();

		try {

			StudentResponseDTO studentResponse = coursesReviewService.fetchStudentInfo(studentId, errorList);

			if (CollectionUtils.isEmpty(errorList)) {
				responseBody.setData(studentResponse);
			} else {
				responseBody.setError(errorList);
			}

			responseBody.setStatus(CoursesReviewConstant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			responseBody.setStatus(CoursesReviewConstant.FAILURE);

			// message is being sent only during exception
			responseBody.setMessage(e.getMessage());
		}

		return responseBody;

	}
	
	@ApiOperation(value = "Get courses info based on the student Id", notes = "Provide the courses info of a student, if it exists in the database", response = ResponseDTO.class)
	@GetMapping(value = UrlConstants.COURSES_URL, produces = "application/json")
	public ResponseDTO<CoursesResponseDTO> getCoursesInfo(
			@ApiParam(value = "ID of the student whose courses info you need to retrieve", required = true) @PathVariable("studentId") Integer studentId) {

		ResponseDTO<CoursesResponseDTO> responseBody = new ResponseDTO<>();

		List<ErrorDTO> errorList = new ArrayList<>();

		try {

			CoursesResponseDTO coursesResponse = coursesReviewService.fetchCoursesInfo(studentId, errorList);

			if (CollectionUtils.isEmpty(errorList)) {
				responseBody.setData(coursesResponse);
			} else {
				responseBody.setError(errorList);
			}

			responseBody.setStatus(CoursesReviewConstant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			responseBody.setStatus(CoursesReviewConstant.FAILURE);

			// message is being sent only during exception
			responseBody.setMessage(e.getMessage());
		}

		return responseBody;
	}
}
