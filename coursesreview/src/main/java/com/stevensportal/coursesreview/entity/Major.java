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
@Table(name = "Major")
public class Major {
	
	@Id
	@Column(name = "Major_ID")
	private int majorId; 

	@Column(name = "Name")
	private String name;

	@Column(name = "Created_By")
	private String createdBy; 
	
	@Column(name = "Created_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name = "Modified_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

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

	@Override
	public String toString() {
		return "Major [majorId=" + majorId + ", name=" + name + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + "]";
	}
	
}
