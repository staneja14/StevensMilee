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
import com.stevensportal.coursesreview.contract.response.ProfessorResponseDTO;
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
@Api(value = "Professor's API", description = "[All Professor related APIs]")
@RestController
@RequestMapping(UrlConstants.CONTROLLER_URL)
public class ProfessorController {

	@Autowired
	CoursesReviewService coursesReviewService;
	
	@ApiOperation(value = "Get professor info based on the course Id", notes = "Provide the professor info of a course, if it exists in the database", response = ResponseDTO.class)
	@GetMapping(value = UrlConstants.PROFESSOR_URL, produces = "application/json")
	public ResponseDTO<ProfessorResponseDTO> getProfessorInfo(
			@ApiParam(value = "ID of the course whose professor info you need to retrieve", required = true) @PathVariable("courseId") Integer courseId) {

		ResponseDTO<ProfessorResponseDTO> responseBody = new ResponseDTO<>();

		List<ErrorDTO> errorList = new ArrayList<>();

		try {

			ProfessorResponseDTO professorResponse = coursesReviewService.fetchProfessorInfo(courseId, errorList);

			if (CollectionUtils.isEmpty(errorList)) {
				responseBody.setData(professorResponse);
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
