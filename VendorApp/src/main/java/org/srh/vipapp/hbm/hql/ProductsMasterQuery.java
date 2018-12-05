package org.srh.vipapp.hbm.hql;

import org.srh.vipapp.hbm.dto.ProductsMaster;

/**
 * Contains HQL for the {@link ProductsMaster} entity.
 * Date: 03 Dec 2018
 * @author Anglita
 */
public final class ProductsMasterQuery {

	private ProductsMasterQuery() {}
	public static final String GET_ALL_PRODUCTS_$N = "GET_ALL_PRODUCTS";
	public static final String GET_ALL_PRODUCTS_$Q = "FROM ProductsMaster WHERE deleteFlag=0";
	public static final String FIND_PRODUCT_BY_PRODUCTNAME_$P1 = "productName";
	public static final String FIND_PRODUCT_BY_PRODUCTNAME_$N = "FIND_PRODUCT_BY_PRODUCTNAME";
	public static final String FIND_PRODUCT_BY_PRODUCTNAME_$Q = "FROM ProductsMaster WHERE deleteFlag=0 AND productName=:" + FIND_PRODUCT_BY_PRODUCTNAME_$P1;
	public static final String FIND_PRODUCT_BY_OFFERS_$P1 = "onOffer";
	public static final String FIND_PRODUCT_BY_OFFERS_$N = "FIND_PRODUCTS_BY_OFFERS";
	public static final String FIND_PRODUCT_BY_OFFERS_$Q = "FROM ProductsMaster WHERE deleteFlag=0 AND onOffer = 1";
	public static final String FIND_PRODUCT_BY_PRODUCTTYPE_$P1 = "productTypeId";
	public static final String FIND_PRODUCT_BY_PRODUCTTYPE_$N = "FIND_PRODUCTS_BY_PRODUCTTYPE";
	public static final String FIND_PRODUCT_BY_PRODUCTTYPE_$Q = "FROM ProductsMaster WHERE deleteFlag=0 AND productTypeId" + FIND_PRODUCT_BY_PRODUCTTYPE_$P1;

}
