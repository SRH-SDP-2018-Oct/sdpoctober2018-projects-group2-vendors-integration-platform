/**
 * 
 */
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

import org.srh.annotation.POJO;
import org.srh.vipapp.hbm.hql.VendorMasterQuery;

@Entity
@Table(name="vendor_master")
@NamedQuery(name=VendorMasterQuery.GET_ALL_VENDOR_$N, query=VendorMasterQuery.GET_ALL_VENDOR_$Q)
@NamedQuery(name=VendorMasterQuery.FIND_VENDOR_BY_VENDORNAME_$N, query=VendorMasterQuery.FIND_VENDOR_BY_VENDORNAME_$Q)
@POJO( hidden= {"setCreatedBy","setModifiedBy"}, hiddenParam= {"org.srh.vipapp.hbm.dto.UserMaster","org.srh.vipapp.hbm.dto.UserMaster"} )


/**
 * The Entity representing the table 'vendor_master' from the 'vendor_app' database.
 * Date: 30 Nov 2018
 * @author Maitreyee
 */
public class VendorMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int vendorId;

	@ManyToOne
	@JoinColumn(name="createdBy")
	private UserMaster createdBy;
	@ManyToOne
	@JoinColumn(name="modifiedBy")
	private UserMaster modifiedBy;

	private String vendorName;
	private String phone = "";
	private String email = "";
	private String country = "Germany";
	private boolean deleteFlag = false;
	private Date createdOn = new Date();
	private Date modifiedOn = new Date();
	
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public UserMaster getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(UserMaster createdBy) {
		this.createdBy = createdBy;
	}
	public UserMaster getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(UserMaster modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
