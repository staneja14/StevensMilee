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
@Table(name = "Professor")
public class Professor {
	
	@Id
	@Column(name = "Prof_ID")
	private int profId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Education")
	private String education;
	
	@Column(name = "Created_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name = "Modified_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	
	@Column(name = "Rating")
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

	@Override
	public String toString() {
		return "Professor [profId=" + profId + ", name=" + name + ", education=" + education + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + ", rating=" + rating + "]";
	}
	
}
