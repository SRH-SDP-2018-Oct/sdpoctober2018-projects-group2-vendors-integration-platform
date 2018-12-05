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


@Entity
@Table(name="products_master")

/*
 * The 'product_master' table entity for 'vendor_integration_platform' database.
 * Date:01 Dec 2018
 * @author Anglita
 */
public class ProductsMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;

	private int productId;

	@ManyToOne
	@JoinColumn(name="productTypeId")
	private ProductType productTypeId;

	private String product;

	private String  productDescription;

	private float productPrice;

	private int offersId;
	
	private boolean onOffers;

	private int vendorId;

	private int branchId;
	
	private boolean deleteFlag = false;
	
	private int createdBy;
	
	private Date createdOn;
	
	private int modifiedBy;
	
	private Date modifiedOn;
	
	public int getId() {
		
		return id;
	}
	public void setId(int id) {
		
		this.id = id;
	}
	
	public int getProductId() {
		
		return productId;
	}
	public void setProductId(int productId) {
		
		this.productId = productId;
	}	
	public ProductType getProductTypeId()
	{
		return productTypeId;
	}
	public void setProductTypeId(ProductType productTypeId)
	{
		this.productTypeId = productTypeId;
	}

	public String getProduct()
	{
		return product;
	}
	
	public void setProduct(String product)
	{
		this.product = product;
	}
	
	public String getProductDescription()
	{
		return productDescription;
	}
	public void setProductDescription(String productDescription)
	{
		this.productDescription = productDescription;
	}
	
	public boolean getOnOffers() 
	{
		return onOffers;
	}
	public void setOnOffers(boolean onOffers) 
	{
		this.onOffers = onOffers;
	}	
	public float getProductPrice() 
	{
		return productPrice;
	}
	public void setProductPrice(int productPrice) 
	{
		this.productPrice = productPrice;
	}	
	
	public int getOffersId() 
	{
		return offersId;
	}
	public void setOffersId(int offersId) 
	{
		this.offersId = offersId;
	}	
	
	public int getVendorsId() 
	{
		return vendorId;
	}
	public void setVendorsId(int vendorId) 
	{
		this.vendorId = vendorId;
	}	
	public int getbranchId() 
	{
		return branchId;
	}
	public void setbranchId(int branchId) 
	{
		this.branchId = branchId;
	}	
	
	public boolean getDeleteFlag() 
	{
		return deleteFlag;
	}
	
	public void setDeleteFlag(boolean deleteFlag) 
	{
		this.deleteFlag = deleteFlag;
	}
	
	public int getCreatedBy() 
	{
		return createdBy;
	}
	
	public void setCreatedBy(int createdBy) 
	{
		this.createdBy = createdBy;
	}
	
	public Date getCreatedOn() 
	{
		return createdOn;
	}
	
	public void setCreatedOn(Date createdOn) 
	{
		this.createdOn = createdOn;
	}
	
	public int getModifiedBy() 
	{
		return modifiedBy;
	}
	
	public void setModifiedBy(int modifiedBy) 
	{
		this.modifiedBy = modifiedBy;
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
