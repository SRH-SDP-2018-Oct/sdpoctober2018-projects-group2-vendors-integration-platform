package org.srh.nettiapp.hbm.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The 'product_type' table entity for 'vendor_integration_platform' database.
 * Date:01 Dec 2018
 * @author Shraddha
 */
@Entity
@Table(name="product_type")
public class ProductType {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int prodTypeId;

	private String productTypeName;
	private boolean deleteFlag;

	public int getProductTypeId() {
		return prodTypeId;
	}
	public void setProductTypeId(int prodTypeId) {
		this.prodTypeId = prodTypeId;
	}

	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public boolean getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}



