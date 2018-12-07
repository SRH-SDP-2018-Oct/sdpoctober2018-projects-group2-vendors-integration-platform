package org.srh.vipapp.hbm.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The 'product_type' table entity for 'vendor_integration_platform' database.
 * Date:01 Dec 2018
 * @author Anglita
 */
@Entity
@Table(name="product_type")
public class ProductType {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productTypeId;

	@ManyToOne
	@JoinColumn(name="createdBy")
	private UserMaster createdBy;
	@ManyToOne
	@JoinColumn(name="modifiedBy")
	private UserMaster modifiedBy;

	private String productTypeName;
	private boolean deleteFlag = false;
	private Date createdOn = new Date();
	private Date modifiedOn = new Date();

	public int getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
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
