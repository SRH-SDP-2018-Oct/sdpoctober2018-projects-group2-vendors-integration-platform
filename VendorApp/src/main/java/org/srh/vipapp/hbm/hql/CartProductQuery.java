package org.srh.vipapp.hbm.hql;

import org.srh.vipapp.hbm.dto.CartProduct;

/**
 * Contains HQL for the {@link CartProduct} entity.
 * Date: 10 Dec 2018
 * @author Vivek
 */
public final class CartProductQuery {

	private CartProductQuery() {}

	public static final String FIND_PRODUCT_BY_CART_$P1 = "cartId";
	public static final String FIND_PRODUCT_BY_CART_$N = "FIND_PRODUCT_BY_CART";
	public static final String FIND_PRODUCT_BY_CART_$Q = "FROM CartProduct "
			+ " WHERE deleteFlag=0 AND cartId=:"+FIND_PRODUCT_BY_CART_$P1;
}
