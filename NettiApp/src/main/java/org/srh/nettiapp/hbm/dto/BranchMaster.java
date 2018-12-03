package org.srh.nettiapp.hbm.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.srh.nettiapp.hbm.hql.BranchMasterQuery;

/**
 * The Entity representing the table 'branch_master' from the 'netti_vendor' database.
 * Date: 01 Dec 2018
 * @author YASHAS
 */

@Entity
@Table(name="branch_master")
@NamedQuery(name=BranchMasterQuery.GET_ALL_BRANCHES_IN_CITY_$N, query=BranchMasterQuery.GET_ALL_BRANCHES_IN_CITY_$Q)
public class BranchMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE) // Auto generate (increment id)
	private int branchId ;

	private String location ;
	private String  locationLat;
	private String  locationLon ;
	private String city;
	private boolean deleteFlag = false;
	private Date createdOn = new Date();
	private Date modifiedOn = new Date();

	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocationLat() {
		return locationLat;
	}
	public void setLocationLat(String locationLat) {
		this.locationLat = locationLat;
	}
	public String getLocationLon() {
		return locationLon;
	}
	public void setLocationLon(String locationLon) {
		this.locationLon = locationLon;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
