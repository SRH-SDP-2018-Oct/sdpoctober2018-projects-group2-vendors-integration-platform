package org.srh.vipapp.hbm.hql;

/**
 * Contains HQL for the {@link CustomerFavouriteList} entity.
 * Date: 10 Dec 2018
 * @author Anglita
 */
public class CustomerFavouriteListQuery {

	private CustomerFavouriteListQuery() { }

	public static final String GET_FAVOURITE_CART_BY_CUSTOMERID_$P1 = "customerId";
	public static final String GET_FAVOURITE_CART_BY_CUSTOMERID_$N = "GET_FAVOURITE_CART_BY_CUSTOMERID";
	public static final String GET_FAVOURITE_CART_BY_CUSTOMERID_$Q = "FROM CustomerFavouriteList"
			+ " WHERE deleteFlag=0 AND customerId=:" + GET_FAVOURITE_CART_BY_CUSTOMERID_$P1
			+ " ORDER BY createdOn DESC ";

	public static final String GET_FAVOURITE_CART_PRODUCTS_$P1 = "customerFavouriteList";
	public static final String GET_FAVOURITE_CART_PRODUCTS_$N = "GET_FAVOURITE_CART_PRODUCTS";
	public static final String GET_FAVOURITE_CART_PRODUCTS_$Q = "FROM FavouriteListProduct"
			+ " WHERE deleteFlag=0 AND listId=:" + GET_FAVOURITE_CART_PRODUCTS_$P1;


}
