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

import org.srh.vipapp.hbm.hql.ProductTypeQuery;


/**
 * The 'product_type' table entity for 'vendor_integration_platform' database.
 * Date:01 Dec 2018
 * @author Anglita
 */
@Entity
@Table(name="product_type")
@NamedQuery(name=ProductTypeQuery.GET_PRODUCT_TYPES_FOR_VENDOR_$N, query=ProductTypeQuery.GET_PRODUCT_TYPES_FOR_VENDOR_$Q)
public class ProductType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int productTypeId;

	@ManyToOne
	@JoinColumn(name="vendorId")
	private VendorMaster vendorId;

	@ManyToOne
	@JoinColumn(name="createdBy")
	private UserMaster createdBy;
	@ManyToOne
	@JoinColumn(name="modifiedBy")
	private UserMaster modifiedBy;

	private String productTypeName;
	private Boolean deleteFlag = false;
	private Date createdOn = new Date();
	private Date modifiedOn = new Date();

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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

	public VendorMaster getVendorId() {
		return vendorId;
	}
	public void setVendorId(VendorMaster vendorId) {
		this.vendorId = vendorId;
	}

	public Boolean isDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Boolean deleteFlag) {
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
