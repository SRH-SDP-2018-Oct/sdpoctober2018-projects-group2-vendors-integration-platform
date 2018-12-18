package org.srh.constants;

public enum KeyPairConstant {

	PRODUCT_ID("productId"),
	PRODUCT_NAME("productName"), 
	PRODUCT_TYPE_ID("productTypeId"), 
	PRODUCT_DESCRIPTION("productDescription"), 
	PRODUCT_PRICE("productPrice"), 
	BRANCH_ID("branchId"),
	DELETE_FLAG("deleteFlag");

	private String enumKey = null;

	KeyPairConstant(String key) {
		enumKey = key;
	}

	@Override
	public String toString() {
		return enumKey;
	}
}


