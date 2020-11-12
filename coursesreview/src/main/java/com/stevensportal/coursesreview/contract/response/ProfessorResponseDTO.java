package com.stevensportal.coursesreview.contract.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author staneja14
 *
 */
@ApiModel(description = "Details about the ProfessorResponse")
@JsonInclude(Include.NON_NULL)
public class ProfessorResponseDTO {

	@ApiModelProperty(notes = "Unique Id of the Professor")
	private int profId;
	
	@ApiModelProperty(notes = "Name of the professor")
	private String name;
	
	@ApiModelProperty(notes = "Education of the professor")
	private String education;
	
	@ApiModelProperty(notes = "Rating of the professor")
	private int rating;

	/**
	 * @return the profId
	 */
	public int getProfId() {
		return profId;
	}

	/**
	 * @param profId the profId to set
	 */
	public void setProfId(int profId) {
		this.profId = profId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the education
	 */
	public String getEducation() {
		return education;
	}

	/**
	 * @param education the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "ProfessorResponseDTO [profId=" + profId + ", name=" + name + ", education=" + education + ", rating="
				+ rating + "]";
	}
}
