package org.srh.constants;

public enum KeyPairConstant {

	PRODUCT_ID("id"),
	PRODUCT_NAME("name"),
	PRODUCT_TYPE("type"),
	PRODUCT_DESCRIPTION("description"),
	PRODUCT_PRICE("price"), 
	BRANCH("branch"),
	DELETEFLAG("deleteFlag");

	private String enumKey = null;

	KeyPairConstant(String key) {
		enumKey = key;
	}

	public String key() {
		return enumKey;
	}
}


