package org.srh.vipapp.hbm.dto;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="customer_favouritelist")
/**
 * The Entity representing the table 'customer_favouritelist' from the 'vendor_integration_app' database.
 * Date: 09 Dec 2018
 * @author Anglita
 */
public class CustomerFavouriteList {


	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private CustomerMaster customerId;
	
	@ManyToOne
	@JoinColumn(name="productId")
	private ProductsMaster productId;
	
	@ManyToOne
	@JoinColumn(name="createdBy")
	private UserMaster createdBy;

	@ManyToOne
	@JoinColumn(name="modifiedBy")
	private UserMaster modifiedBy;
	
	private boolean deleteFlag = false; 

	private Date createdOn = new Date();

	private Date modifiedOn = new Date();
	
	public long getListId() 
	{
		return id;
	}
	
	public void setListId(long id) 
	{
		this.id = id;
	}
	
	public CustomerMaster getId() 
	{
		return customerId;
	}
	
	public CustomerMaster getCustomerId() 
	{
		return customerId;
	}
	public void setCustomerId(CustomerMaster customerId) 
	{
		this.customerId = customerId;
	}
	
	public ProductsMaster getProductId() 
	{
		return productId;
	}
	
	public void setProductId(ProductsMaster productId) 
	{
		this.productId = productId;
	}
	
	public UserMaster getCreatedBy() 
	{
		return createdBy;
	}
	
	public void setCreatedBy(UserMaster createdBy) 
	{
		this.createdBy = createdBy;
	}
	
	public UserMaster getModifiedBy() 
	{
		return modifiedBy;
	}
	
	public void setModifiedBy(UserMaster modifiedBy) 
	{
		this.modifiedBy = modifiedBy;
	}
	
	public boolean isDeleteFlag() 
	{
		return deleteFlag;
	}
	
	public void setDeleteFlag(boolean deleteFlag) 
	{
		this.deleteFlag = deleteFlag;
	}
	
	public Date getCreatedOn() 
	{
		return createdOn;
	}
	
	public void setCreatedOn(Date createdOn) 
	{
		this.createdOn = createdOn;
	}
	
	public Date getModifiedOn() 
	{
		return modifiedOn;
	}
	
	public void setModifiedOn(Date modifiedOn) 
	{
		this.modifiedOn = modifiedOn;
	}

}
