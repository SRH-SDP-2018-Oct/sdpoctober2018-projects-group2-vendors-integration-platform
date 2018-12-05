package org.srh.nettiapp.hbm.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/*
 * The 'product_type' table entity for 'vendor_integration_platform' database.
 * Date:01 Dec 2018
 * @author Shraddha
 */
@Entity
@Table(name="product_type")
public class ProductType {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productTypeId;

	private String productType;

	private boolean isDeleted;

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}



