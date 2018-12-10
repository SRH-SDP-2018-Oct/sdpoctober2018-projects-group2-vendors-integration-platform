package org.srh.bean;

import org.srh.constants.ErrorCode;
import org.srh.vipapp.hbm.dto.CustomerCart;
import org.srh.vipapp.hbm.dto.CustomerMaster;
import org.srh.vipapp.hbm.dto.ProductsMaster;

public class CartBean {

	private ProductsMaster productsMaster;
	private CustomerMaster customerMaster;
	private ErrorCode errorCode;
	private String errorDesc;
	private CustomerCart customerCart;

	public CartBean(ErrorCode errorCode, String errorDesc) {
		this.errorCode = errorCode;
		this.errorDesc = errorDesc;
	}

	public CartBean(ProductsMaster productsMaster, CustomerMaster customerMaster) {
		this.productsMaster = productsMaster;
		this.customerMaster = customerMaster;
	}

	public ProductsMaster getProductsMaster() {
		return productsMaster;
	}
	public void setProductsMaster(ProductsMaster productsMaster) {
		this.productsMaster = productsMaster;
	}
	public CustomerMaster getCustomerMaster() {
		return customerMaster;
	}
	public void setCustomerMaster(CustomerMaster customerMaster) {
		this.customerMaster = customerMaster;
	}
	public ErrorCode getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	public CustomerCart getCustomerCart() {
		return customerCart;
	}
	public void setCustomerCart(CustomerCart customerCart) {
		this.customerCart = customerCart;
	}

}
