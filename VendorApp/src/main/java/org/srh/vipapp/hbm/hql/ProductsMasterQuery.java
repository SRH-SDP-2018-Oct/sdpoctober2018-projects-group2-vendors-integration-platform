package org.srh.vipapp.hbm.hql;

import org.srh.util.StringUtil;
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
	public static final String FIND_PRODUCT_BY_PRODUCTNAME_$Q = "FROM ProductsMaster "
			+ " WHERE deleteFlag=0 AND productName=:" + FIND_PRODUCT_BY_PRODUCTNAME_$P1;

	/*
	TODO - Query throwing error need to fix this later
	public static final String FIND_PRODUCT_BY_PRODUCTTYPE_$P1 = "productTypeId";
	public static final String FIND_PRODUCT_BY_PRODUCTTYPE_$N = "FIND_PRODUCTS_BY_PRODUCTTYPE";
	public static final String FIND_PRODUCT_BY_PRODUCTTYPE_$Q = "FROM ProductsMaster "
			+ " WHERE deleteFlag=0 AND productTypeId=:" + FIND_PRODUCT_BY_PRODUCTTYPE_$P1;
	*/

	public static final String FIND_PRODUCT_BY_OFFERS_$N = "FIND_PRODUCTS_BY_OFFERS";
	public static final String FIND_PRODUCT_BY_OFFERS_$Q = "FROM ProductsMaster "
			+ " WHERE deleteFlag=0 AND hasAnOffer=1";


	public static final String GET_FREQUENT_PRODUCDTS_P1 = "customerId";
	public static final String GET_FREQUENT_PRODUCDTS_Q = StringUtil.append("SELECT ",
			" cp.productId, COUNT(*), cp.*  " ,
			" FROM cart_product cp ",
			" INNER JOIN customer_cart cc ON cc.cartId = cp.cartId " + 
			" WHERE cc.customerId = :", GET_FREQUENT_PRODUCDTS_P1,
			" GROUP BY cp.productId ");
}
