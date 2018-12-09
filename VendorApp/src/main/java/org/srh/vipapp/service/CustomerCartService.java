package org.srh.vipapp.service;

import org.srh.bean.ServiceResp;
import org.srh.bean.ServiceRespArray;

/**
 * Service Interface to perform the task related to Application Customer's cart.  <br/>
 * Date: 09 Dec 2018
 * @author Anglita
 */
public interface CustomerCartService {

	/**
	 * Returns all the products.
	 * @return serviceRespArray {@link ServiceRespArray}
	 */
	ServiceRespArray getAllCarts();

	/**
	 * Returns cart with the given cartId.
	 * @param cartId {@link String}
	 * @return serviceResp {@link ServiceResp}
	 */
	ServiceResp	getCartsByCartId(String cartId);
	
	/**
	 * Returns carts for the given userId.
	 * @param userId {@link String}
	 * @return serviceRespArray {@link ServiceRespArray}
	 */
	ServiceRespArray getCartsByUserId(String userId);
	
}
