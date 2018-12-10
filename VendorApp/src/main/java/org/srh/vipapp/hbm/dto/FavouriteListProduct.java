package org.srh.vipapp.hbm.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.srh.annotation.POJO;

@Entity
@Table(name = "favouritelist_product")
@POJO(hidden= {"setCreatedBy","setModifiedBy"},
	hiddenParam= {"org.srh.vipapp.hbm.dto.UserMaster","org.srh.vipapp.hbm.dto.UserMaster"}
)
/**
 * The Entity representing the table 'customer_cart' from the
 * 'vendor_integration_app' database. Date: 08 Dec 2018
 * 
 * @author Anglita
 */
public class FavouriteListProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "listId")
	private CustomerFavouriteList listId;

	@ManyToOne
	@JoinColumn(name = "productId")
	private ProductsMaster productId;

	@ManyToOne
	@JoinColumn(name = "createdBy")
	private UserMaster createdBy;

	@ManyToOne
	@JoinColumn(name = "modifiedBy")
	private UserMaster modifiedBy;

	private boolean deleteFlag = false;
	private Date createdOn = new Date();
	private Date modifiedOn = new Date();

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public CustomerFavouriteList getListId() {
		return listId;
	}
	public void setListId(CustomerFavouriteList listId) {
		this.listId = listId;
	}

	public ProductsMaster getProductId() {
		return productId;
	}
	public void setProductId(ProductsMaster productId) {
		this.productId = productId;
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

	public boolean getDeleteFlag() {
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
