package org.srh.vipapp.hbm.dto;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.srh.annotation.POJO;
import org.srh.vipapp.hbm.hql.CustomerFavouriteListQuery;

@Entity
@Table(name = "customer_favouritelist")

@NamedQuery(name = CustomerFavouriteListQuery.GET_FAVOURITE_CART_BY_CUSTOMERID_$N, query = CustomerFavouriteListQuery.GET_FAVOURITE_CART_BY_CUSTOMERID_$Q)
@POJO(hidden = { "setCustomerId", "setCreatedBy", "setModifiedBy" },
		hiddenParam = { "org.srh.vipapp.hbm.dto.CustomerMaster",
				"org.srh.vipapp.hbm.dto.UserMaster", "org.srh.vipapp.hbm.dto.UserMaster" })
/**
 * The Entity representing the table 'customer_favouritelist' from the
 * 'vendor_integration_app' database. Date: 09 Dec 2018
 * 
 * @author Anglita
 */
public class CustomerFavouriteList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long listId;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private CustomerMaster customerId;

	@ManyToOne
	@JoinColumn(name = "createdBy")
	private UserMaster createdBy;

	@ManyToOne
	@JoinColumn(name = "modifiedBy")
	private UserMaster modifiedBy;

	private boolean deleteFlag = false;

	private Date createdOn = new Date();

	private Date modifiedOn = new Date();

	public long getListId() {
		return listId;
	}

	public void setListId(long listId) {
		this.listId = listId;
	}

	public CustomerMaster getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerMaster customerId) {
		this.customerId = customerId;
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
