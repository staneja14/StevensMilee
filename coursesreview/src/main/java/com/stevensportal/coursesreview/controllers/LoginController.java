package com.stevensportal.coursesreview.controllers;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stevensportal.coursesreview.constant.CoursesReviewConstant;
import com.stevensportal.coursesreview.constant.UrlConstants;
import com.stevensportal.coursesreview.contract.request.LoginRequestDTO;
import com.stevensportal.coursesreview.contract.response.LoginResponseDTO;
import com.stevensportal.coursesreview.contract.response.base.ErrorDTO;
import com.stevensportal.coursesreview.contract.response.base.ResponseDTO;
import com.stevensportal.coursesreview.exceptions.CoursesReviewException;
import com.stevensportal.coursesreview.exceptions.InputValidationException;
import com.stevensportal.coursesreview.service.CoursesReviewService;
import com.stevensportal.coursesreview.validators.RequestValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.*;


/**
 * @author staneja14
 *
 */
@Api(value = "Login API", description = "[All Login related APIs]")
@RestController
@RequestMapping(UrlConstants.CONTROLLER_URL)
public class LoginController {
	
	@Autowired
	CoursesReviewService coursesReviewService;
	
	@CrossOrigin
 	@ApiOperation(value = "Authenticate a user based on the emailId", notes = "Provide the id of the user if it exists in the database", response = ResponseDTO.class)
	@PostMapping(value = UrlConstants.LOGIN_URL, produces = "application/json")
	public ResponseDTO<LoginResponseDTO> authenticateUser(@RequestBody LoginRequestDTO loginRequest) {

		ResponseDTO<LoginResponseDTO> responseBody = new ResponseDTO<>();

		List<ErrorDTO> errorList = new ArrayList<>();
		RequestValidator.validateLoginRequest(loginRequest, errorList);

		try {
			if (CollectionUtils.isEmpty(errorList)) {
				// All request validations passed successfully 
				LoginResponseDTO loginResponse = coursesReviewService.verifyUser(loginRequest.getEmailId(), errorList);
				
				if(CollectionUtils.isNotEmpty(errorList)) {
					responseBody.setError(errorList);
				} else {
					// All business validations passed successfully
					responseBody.setData(loginResponse);
				}
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
