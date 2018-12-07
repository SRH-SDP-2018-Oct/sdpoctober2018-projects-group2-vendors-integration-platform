package org.srh.vipapp.hbm.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.srh.vipapp.hbm.hql.ProductsMasterQuery;

@Entity
@Table(name = "products_master")
@NamedQuery(name = ProductsMasterQuery.GET_ALL_PRODUCTS_$N, query = ProductsMasterQuery.GET_ALL_PRODUCTS_$Q)
@NamedQuery(name = ProductsMasterQuery.FIND_PRODUCT_BY_PRODUCTNAME_$N, query = ProductsMasterQuery.FIND_PRODUCT_BY_PRODUCTNAME_$Q)
@NamedQuery(name = ProductsMasterQuery.FIND_PRODUCT_BY_PRODUCTNAME_$N, query = ProductsMasterQuery.FIND_PRODUCT_BY_PRODUCTNAME_$Q)
@NamedQuery(name = ProductsMasterQuery.FIND_PRODUCT_BY_PRODUCTTYPE_$N, query = ProductsMasterQuery.FIND_PRODUCT_BY_PRODUCTTYPE_$N)
@NamedQuery(name = ProductsMasterQuery.FIND_PRODUCT_BY_OFFERS_$N, query = ProductsMasterQuery.FIND_PRODUCT_BY_OFFERS_$Q)

/**
 * The 'product_master' table entity for 'vendor_integration_platform' database.
 * Date:01 Dec 2018
 * 
 * @author Anglita
 */
public class ProductsMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int productId;

	@ManyToOne
	@JoinColumn(name = "productTypeId")
	private ProductType productTypeId;

	@ManyToOne
	@JoinColumn(name="vendorId")
	private VendorMaster vendorId;

	@ManyToOne
	@JoinColumn(name="createdBy")
	private UserMaster createdBy;
	@ManyToOne
	@JoinColumn(name="modifiedBy")
	private UserMaster modifiedBy;

	@ManyToOne
	@JoinColumn(name="branchId")
	private VendorBranch branchId;

	private String productName;
	private BigDecimal productPrice;
	private String productDescription;
	private String productShelfLife = "";
	
	private Boolean hasAnOffer = false;
	private String offerDetail;

	private String otherDetails = "{}";
	private String apiDetails = "{}";

	private Boolean deleteFlag = false;
	private Date createdOn = new Date();
	private Date modifiedOn = new Date();

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public ProductType getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(ProductType productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductShelfLife() {
		return productShelfLife;
	}

	public void setProductShelfLife(String productShelfLife) {
		this.productShelfLife = productShelfLife;
	}

	public Boolean getHasAnOffer() {
		return hasAnOffer;
	}

	public void setHasAnOffer(Boolean hasAnOffer) {
		this.hasAnOffer = hasAnOffer;
	}

	public String getOfferDetail() {
		return offerDetail;
	}

	public void setOfferDetail(String offerDetail) {
		this.offerDetail = offerDetail;
	}

	public VendorMaster getVendorId() {
		return vendorId;
	}

	public void setVendorId(VendorMaster vendorId) {
		this.vendorId = vendorId;
	}

	public VendorBranch getBranchId() {
		return branchId;
	}

	public void setBranchId(VendorBranch branchId) {
		this.branchId = branchId;
	}

	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	public String getApiDetails() {
		return apiDetails;
	}

	public void setApiDetails(String apiDetails) {
		this.apiDetails = apiDetails;
	}

	public Boolean getDeleteFlag() {
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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public UserMaster getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(UserMaster modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

}
