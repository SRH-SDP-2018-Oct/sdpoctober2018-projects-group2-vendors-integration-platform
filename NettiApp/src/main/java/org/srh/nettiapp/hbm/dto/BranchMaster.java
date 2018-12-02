package org.srh.nettiapp.hbm.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author YASHAS
 * The Entity representing the table 'branch_master' from the 'netti_vendor' database.
 * Date: 01 Dec 2018
 */

@Entity
@Table(name="branch_master")
public class BranchMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE) // Auto generate (increment id)
	private int branchId ;
	
	private String branchLocation ;
	private String  branchLocationLat;
	private String  branchLocationLon ;
	private boolean  deleteFlag;
	private Date createdOn = new Date();
	private Date modifiedOn = new Date();
	
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchLocation() {
		return branchLocation;
	}
	public void setBranchLocation(String branchLocation) {
		this.branchLocation = branchLocation;
	}
	public String getBranchLocationLat() {
		return branchLocationLat;
	}
	public void setBranchLocationLat(String branchLocationLat) {
		this.branchLocationLat = branchLocationLat;
	}
	public String getBranchLocationLon() {
		return branchLocationLon;
	}
	public void setBranchLocationLon(String branchLocationLon) {
		this.branchLocationLon = branchLocationLon;
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
