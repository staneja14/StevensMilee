package com.stevensportal.coursesreview.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stevensportal.coursesreview.constant.CoursesReviewConstant;
import com.stevensportal.coursesreview.constant.UrlConstants;
import com.stevensportal.coursesreview.contract.request.PostReviewRequest;
import com.stevensportal.coursesreview.contract.response.ReviewsResponseDTO;
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
@Api(value = "Review's APIs", description = "[All Reviews related APIs]")
@RestController
@RequestMapping(UrlConstants.CONTROLLER_URL)
public class ReviewsController {

	@Autowired
	CoursesReviewService coursesReviewService;

	@ApiOperation(value = "Get reviews based on the courseId", notes = "Provide the reviews of the course, whose id has been passed in the request url, if it exists in the database", response = ResponseDTO.class)
	@GetMapping(value = UrlConstants.REVIEWS_URL, produces = "application/json")
	public ResponseDTO<ReviewsResponseDTO> getReviewsInfo(
			@ApiParam(value = "ID of the course whose reviews you need to retrieve", required = true) @PathVariable("courseId") Integer courseId) {

		ResponseDTO<ReviewsResponseDTO> responseBody = new ResponseDTO<>();

		List<ErrorDTO> errorList = new ArrayList<>();

		try {
			ReviewsResponseDTO reviewsResponse = coursesReviewService.fetchReviews(courseId, errorList);

			if (CollectionUtils.isEmpty(errorList)) {
				responseBody.setData(reviewsResponse);
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
	
	@ApiOperation(value = "Post a review on the course", notes = "This API stores a review, given by some student, on a particular course", response = ResponseDTO.class)
	@PostMapping(value = UrlConstants.REVIEW_POST_URL, produces = "application/json")
	public ResponseDTO<?> postReview(@Valid @RequestBody PostReviewRequest postReviewRequest, BindingResult bindingResult) {
		ResponseDTO<?> responseBody = new ResponseDTO<>();
		List<ErrorDTO> errorList = new ArrayList<>();

		if (bindingResult.hasErrors()) {
			
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError error : errors) {
				errorList.add(new ErrorDTO(error.getCode(), error.getDefaultMessage(),
						String.valueOf(error.getRejectedValue())));
			}
			responseBody.setError(errorList);

			responseBody.setStatus(CoursesReviewConstant.SUCCESS);
		} else {
			try {
				
				// All request validations passed successfully
				coursesReviewService.postTheReview(postReviewRequest.getStudentId(), postReviewRequest.getCourseId(),
						postReviewRequest.getDescription(), errorList);

				if (CollectionUtils.isNotEmpty(errorList)) {
					responseBody.setError(errorList);
				} else {
					/*
					 * All business validations are passed successfully. No need to populate any
					 * data here.
					 */
				}
				
				responseBody.setStatus(CoursesReviewConstant.SUCCESS);
			} catch (Exception e) {
				e.printStackTrace();
				responseBody.setStatus(CoursesReviewConstant.FAILURE);

				// message is being sent only during exception
				responseBody.setMessage(e.getMessage());
			}
		}

		return responseBody;
	}

}
