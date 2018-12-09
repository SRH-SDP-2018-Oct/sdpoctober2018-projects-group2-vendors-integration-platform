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
import org.srh.vipapp.hbm.hql.CustomerCartQuery;

@Entity
@Table(name = "customer_cart")
@NamedQuery(name = CustomerCartQuery.GET_ALL_CUSTOMER_CARTS_$N, query = CustomerCartQuery.GET_ALL_CUSTOMER_CARTS_$Q)
@NamedQuery(name = CustomerCartQuery.GET_CUSTOMER_CARTS_BY_CUSTOMERID_$N, query = CustomerCartQuery.GET_CUSTOMER_CARTS_BY_CUSTOMERID_$Q)
@POJO(hidden= {"setProductId","setCustomerId","setCreatedBy","setModifiedBy"},
	hiddenParam= {"org.srh.vipapp.hbm.dto.ProductsMaster","org.srh.vipapp.hbm.dto.CustomerMaster",
			"org.srh.vipapp.hbm.dto.UserMaster","org.srh.vipapp.hbm.dto.UserMaster"}
)
/**
 * The Entity representing the table 'customer_cart' from the
 * 'vendor_integration_app' database. Date: 08 Dec 2018
 * 
 * @author Anglita
 */
public class CustomerCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartId;

	@ManyToOne
	@JoinColumn(name = "productId")
	private ProductsMaster productId;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private CustomerMaster customerId;

	@ManyToOne
	@JoinColumn(name = "createdBy")
	private UserMaster createdBy;

	@ManyToOne
	@JoinColumn(name = "modifiedBy")
	private UserMaster modifiedBy;

	private String displayName;
	private int productCount;
	private boolean deleteFlag = false;
	private Date createdOn = new Date();
	private Date modifiedOn = new Date();

	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public ProductsMaster getProductId() {
		return productId;
	}
	public void setProductId(ProductsMaster productId) {
		this.productId = productId;
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

	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
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
