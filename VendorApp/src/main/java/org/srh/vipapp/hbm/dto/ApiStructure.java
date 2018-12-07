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
import org.srh.vipapp.hbm.hql.ApiStructureQuery;

/**
 * The Entity representing the table 'branch_timings' from the 'aldi_vendor' database.
 * Date: 05 Dec 2018
 * @author Maitreyee
 */

@Entity
@Table(name="api_structure")
@NamedQuery(name=ApiStructureQuery.GET_ALL_VENDOR_API_$N, query=ApiStructureQuery.GET_ALL_VENDOR_API_$Q)
@POJO(
		hidden={"setCreatedBy","setModifiedBy"},
		hiddenParam={"org.srh.vipapp.hbm.dto.UserMaster","org.srh.vipapp.hbm.dto.UserMaster"},
		hideInnerReferredData={"getKeyConstantId","getVendorId"}
)

public class ApiStructure {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;

	@ManyToOne
	@JoinColumn(name="keyConstantId")
	private ApiStructureConstants keyConstantId;

	@ManyToOne
	@JoinColumn(name="vendorId")
	private VendorMaster vendorId;

	@ManyToOne
	@JoinColumn(name="createdBy")
	private UserMaster createdBy;
	@ManyToOne
	@JoinColumn(name="modifiedBy")
	private UserMaster modifiedBy;
	
	private String keyName;
	private boolean deleteFlag = false;
	private Date createdOn = new Date();
	private Date modifiedOn = new Date();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ApiStructureConstants getKeyConstantId() {
		return keyConstantId;
	}
	public void setKeyConstantId(ApiStructureConstants keyConstantId) {
		this.keyConstantId = keyConstantId;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public VendorMaster getVendorId() {
		return vendorId;
	}
	public void setVendorId(VendorMaster vendorId) {
		this.vendorId = vendorId;
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
