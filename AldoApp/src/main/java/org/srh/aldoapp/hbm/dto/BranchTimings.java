
package org.srh.aldoapp.hbm.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The Entity representing the table 'branch_timings' from the 'aldi_vendor' database.
 * Date: 02 Dec 2018
 * @author Vivek
 */

@Entity
@Table(name="branch_timings")
public class BranchTimings {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long id;

	@ManyToOne
	@JoinColumn(name="branchId")
	private BranchMaster branchId ;

	private int dayInWeek;// '1-Sunday, 2-Monday, 3-Tuesday, 4-Wednesday, 5-Thursday, 6-Friday, 7-Saturday',
	private boolean isOpen ;
	private Date openingTime;
	private Date  closingTime;
	private boolean deleteFlag = false;
	private Date createdOn = new Date();
	private Date modifiedOn = new Date();

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public BranchMaster getBranchId() {
		return branchId;
	}
	public void setBranchId(BranchMaster branchId) {
		this.branchId = branchId;
	}

	public int getDayInWeek() {
		return dayInWeek;
	}
	public void setDayInWeek(int dayInWeek) {
		this.dayInWeek = dayInWeek;
	}

	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	public Date getOpeningTime() {
		return openingTime;
	}
	public void setOpeningTime(Date openingTime) {
		this.openingTime = openingTime;
	}
	public Date getClosingTime() {
		return closingTime;
	}
	public void setClosingTime(Date closingTime) {
		this.closingTime = closingTime;
	}
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
}