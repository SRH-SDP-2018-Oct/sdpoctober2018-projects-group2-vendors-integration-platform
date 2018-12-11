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

	public static final String GET_CUSTOMER_CARTS_BY_CUSTOMERID_$P1 = "customerId";
	public static final String GET_CUSTOMER_CARTS_BY_CUSTOMERID_$N = "GET_CUSTOMER_CARTS_BY_CUSTOMERID";
	public static final String GET_CUSTOMER_CARTS_BY_CUSTOMERID_$Q = "FROM CustomerCart"
			+ " WHERE deleteFlag=0 AND customerId=:" + GET_CUSTOMER_CARTS_BY_CUSTOMERID_$P1;

	public static final String GET_LATEST_CUSTOMER_CARTS_BY_CUSTOMERID_$P1 = "customerId";
	public static final String GET_LATEST_CUSTOMER_CARTS_BY_CUSTOMERID_$N = "GET_LATEST_CUSTOMER_CARTS_BY_CUSTOMERID";
	public static final String GET_LATEST_CUSTOMER_CARTS_BY_CUSTOMERID_$Q = "FROM CustomerCart"
			+ " WHERE deleteFlag=0 AND customerId=:" + GET_CUSTOMER_CARTS_BY_CUSTOMERID_$P1
			+ " ORDER BY cartId DESC ";
}
