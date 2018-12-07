package org.srh.aldoapp.hbm.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.srh.aldoapp.hbm.dto.ProductType;

@Entity
@Table(name="products_master")

/**
 * The 'product_master' table entity for 'vendor_integration_platform' database.
 * Date: 05 Dec 2018
 * @author Shraddha
 */

public class ProductMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;

	private int productId;

	@ManyToOne
	@JoinColumn(name = "productTypeId")
	private ProductType productTypeId;

	private String productName;
	private String productDescription;
	private float productPrice;
	private int branchId;

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

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

}
