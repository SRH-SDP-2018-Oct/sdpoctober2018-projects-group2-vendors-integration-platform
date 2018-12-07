package org.srh.vipapp.hbm.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.srh.vipapp.hbm.hql.VendorBranchQuery;

/**
 * The Entity representing the table 'vendor_brach'.
 * Date: 07 Dec 2018
 * @author Vivek
 */

@Entity
@Table(name="vendor_branches")
@NamedQuery(name=VendorBranchQuery.GET_ALL_VENDOR_BRANCHES_$N,query=VendorBranchQuery.GET_ALL_VENDOR_BRANCHES_$Q)
public class VendorBranch {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE) // Auto generate (increment id)
	private int branchId ;

	@ManyToOne
	@JoinColumn(name="vendorId")
	private VendorMaster vendorId;

	@ManyToOne
	@JoinColumn(name="createdBy")
	private UserMaster createdBy;
	@ManyToOne
	@JoinColumn(name="modifiedBy")
	private UserMaster modifiedBy;

	private String location ;
	private String  locationLat;
	private String  locationLon ;
	private String city;
	private Boolean deleteFlag = false;
	private Date createdOn = new Date();
	private Date modifiedOn = new Date();

	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public VendorMaster getVendorId() {
		return vendorId;
	}
	public void setVendorId(VendorMaster vendorId) {
		this.vendorId = vendorId;
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

	public Boolean getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public UserMaster getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(UserMaster createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public UserMaster getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(UserMaster modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}
