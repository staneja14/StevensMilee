package com.stevensportal.coursesreview.contract.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author staneja14
 *
 */
@ApiModel(description = "Details about the CourseResponse")
@JsonInclude(Include.NON_NULL)
public class CourseResponseDTO {

	@ApiModelProperty(notes = "Unique id of the course")
	private int courseId;

	@ApiModelProperty(notes = "Name of the course")
	private String name;

	@ApiModelProperty(notes = "Course's description")
	private String description;
	
	@ApiModelProperty(notes = "Course's semester(Fall/Spring)")
	private String semester;
	
	@ApiModelProperty(notes = "Rating of the course")
	private int rating;
	
	@ApiModelProperty(notes = "Teaching mode of the course")
	private String teachingMode;

	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the semester
	 */
	public String getSemester() {
		return semester;
	}

	/**
	 * @param semester the semester to set
	 */
	public void setSemester(String semester) {
		this.semester = semester;
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

	/**
	 * @return the teachingMode
	 */
	public String getTeachingMode() {
		return teachingMode;
	}

	/**
	 * @param teachingMode the teachingMode to set
	 */
	public void setTeachingMode(String teachingMode) {
		this.teachingMode = teachingMode;
	}

	@Override
	public String toString() {
		return "CourseResponseDTO [courseId=" + courseId + ", name=" + name + ", description=" + description
				+ ", semester=" + semester + ", rating=" + rating + ", teachingMode=" + teachingMode + "]";
	}
	
}
