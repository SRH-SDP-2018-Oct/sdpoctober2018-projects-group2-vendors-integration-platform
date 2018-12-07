package org.srh.nettiapp.hbm.dto;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.srh.nettiapp.hbm.dto.ProductType;
import org.srh.nettiapp.hbm.hql.ProductMasterQuery;

@Entity
@Table(name = "product_master")
@NamedQuery(name=ProductMasterQuery.GET_ALL_PRODUCTS_$N, query=ProductMasterQuery.GET_ALL_PRODUCTS_$Q)

/**
 * The 'product_master' table entity for 'vendor_integration_platform' database.
 * Date:05 Dec 2018
 * 
 * @author Shraddha
 */
public class ProductMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int productId;

	@ManyToOne
	@JoinColumn(name = "productTypeId")
	private ProductType productTypeId;

	@ManyToOne
	@JoinColumn(name = "branchId")
	private BranchMaster branchId;

	private String productName;
	private String productDescription;
	private BigDecimal productPrice;
	private boolean deleteFlag = false;

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

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public BranchMaster getBranchId() {
		return branchId;
	}

	public void setBranchId(BranchMaster branchId) {
		this.branchId = branchId;
	}

	public boolean getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
