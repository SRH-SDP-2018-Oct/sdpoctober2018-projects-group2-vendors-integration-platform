package org.srh.vipapp.service;

import org.srh.bean.ServiceResp;
import org.srh.bean.ServiceRespArray;

/**
 * Service Interface to perform the task related to Application Customer's favourite List.  <br/>
 * Date: 10 Dec 2018
 * @author Anglita
 */
public interface CustomerFavouriteListService {

	/**
	 * Returns cart with the given favourite List ID.
	 * @param id {@link String}
	 * @return serviceResp {@link ServiceResp}
	 */
	ServiceResp	getFavouriteListById(String listId);

	/**
	 * Returns carts for the given customerId.
	 * @param customerId {@link String}
	 * @return serviceRespArray {@link ServiceRespArray}
	 */
	ServiceResp getFavouriteListByCustomerId(String customerId);

	/**
	 * Create favourite list and add a single product to the favourite list
	 * @param data {@link String}
	 * @param customerId {@link String}
	 * @return serviceResp {@link ServiceResp}
	 */
	ServiceResp	addProductToFavouriteList(String data, String customerId);

	/**
	 * Create favourite list and add multiple products to the favourite list
	 * @param data {@link String}
	 * @param customerId {@link String}
	 * @return serviceResp {@link ServiceResp}
	 */
	ServiceResp addProductsToFavouriteList(String data, String customerId);
}
