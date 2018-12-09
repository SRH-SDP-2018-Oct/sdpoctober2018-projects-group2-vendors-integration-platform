package org.srh.vipapp.hbm.hql;

import org.srh.vipapp.hbm.dto.CustomerCart;

/**
 * Contains HQL for the {@link CustomerCart} entity.
 * Date: 09 Dec 2018
 * @author Anglita
 */
public class CustomerCartQuery {

	private CustomerCartQuery() { }

	public static final String GET_ALL_CUSTOMER_CARTS_$N = "GET_ALL_CUSTOMER_CARTS";
	public static final String GET_ALL_CUSTOMER_CARTS_$Q = "FROM CustomerCart"
			+ " WHERE deleteFlag=0";

	public static final String GET_ALL_CUSTOMER_CARTS_BY_USERID_$P1 = "userId";
	public static final String GET_ALL_CUSTOMER_CARTS_BY_USERID_$N = "GET_CUSTOMER_CARTS_BY_USERID";
	public static final String GET_ALL_CUSTOMER_CARTS_BY_USERID_$Q = "FROM CustomerCart"
			+ " WHERE deleteFlag=0 AND userId=:" + GET_ALL_CUSTOMER_CARTS_BY_USERID_$P1;
}
