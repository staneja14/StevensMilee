package com.stevensportal.coursesreview.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author staneja14
 *
 */
@Entity
@Table(name = "Course")
public class Course {
	
	@Id
	@Column(name = "Course_ID")
	private int courseId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "Semester")
	private String semester;
	
	@Column(name = "Created_By")
	private String createdBy; 
	
	@Column(name = "Created_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name = "Modified_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	
	@Column(name = "Rating")
	private int rating;

	@Column(name = "Teaching_Mode")
	private String teachingMode;
	
	@Column(name = "Major_ID")
	private int majorId;
	
	@Column(name = "Prof_ID")
	private int profId;

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
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the modifiedDate
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
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

	/**
	 * @return the majorId
	 */
	public int getMajorId() {
		return majorId;
	}

	/**
	 * @param majorId the majorId to set
	 */
	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

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

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", description=" + description + ", semester="
				+ semester + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + ", rating=" + rating + ", teachingMode=" + teachingMode + ", majorId=" + majorId
				+ ", profId=" + profId + "]";
	}
}
