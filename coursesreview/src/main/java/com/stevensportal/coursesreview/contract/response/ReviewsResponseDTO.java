package com.stevensportal.coursesreview.contract.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author staneja14
 *
 */
@ApiModel(description = "Details about the ReviewsResponse")
@JsonInclude(Include.NON_NULL)
public class ReviewsResponseDTO {
	
	@ApiModelProperty(notes = "Details about the reviews of a course")
	List<ReviewResponseDTO> reviews;

	/**
	 * @return the reviews
	 */
	public List<ReviewResponseDTO> getReviews() {
		return reviews;
	}

	/**
	 * @param reviews the reviews to set
	 */
	public void setReviews(List<ReviewResponseDTO> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "ReviewsResponseDTO [reviews=" + reviews + "]";
	}
	
}
