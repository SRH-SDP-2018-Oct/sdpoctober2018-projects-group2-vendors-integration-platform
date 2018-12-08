package org.srh.vipapp.hbm.hql;

public final class ProductTypeQuery {

	private ProductTypeQuery() {}

	public static final String GET_PRODUCT_TYPES_FOR_VENDOR_$P1 = "vendorId";
	public static final String GET_PRODUCT_TYPES_FOR_VENDOR_$N = "GET_PRODUCT_TYPES_FOR_VENDOR";
	public static final String GET_PRODUCT_TYPES_FOR_VENDOR_$Q = "FROM ProductType "
			+ " WHERE deleteFlag=0  AND  vendorId=:"+GET_PRODUCT_TYPES_FOR_VENDOR_$P1;

}
