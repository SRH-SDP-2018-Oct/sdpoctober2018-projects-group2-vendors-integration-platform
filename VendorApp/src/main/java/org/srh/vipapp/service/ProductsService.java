package org.srh.vipapp.service;

import org.srh.bean.ServiceResp;
import org.srh.bean.ServiceRespArray;

/**
 * Service Interface to perform the task related to Application Products.  <br/>
 * Date: 04 Dec 2018
 * @author Anglita
 */
public interface ProductsService {

	/**
	 * Returns all the products.
	 * @return serviceRespArray {@link ServiceRespArray}
	 */
	ServiceRespArray getAllProducts();

	/**
	 * Returns product with the given ProductId.
	 * @param productId {@link String}
	 * @return serviceResp {@link ServiceResp}
	 */
	ServiceResp	getProductByProductId(String productId);

	/**
	 * Returns product with the given product name.
	 * @param productName {@link String}
	 * @return serviceResp {@link ServiceRespArray}
	 */
	ServiceRespArray getProductsbyName(String productName);

	/**
	 * Returns all the products with  offersId.
	 * @return serviceResp {@link ServiceRespArray}
	 */
	ServiceRespArray getProductsOnOffers();

	/**
	 * Returns all the products with given product type Id.
	 * @param productTypeName {@link String}
	 * @return serviceRespArray {@link ServiceRespArray}
	 */
	ServiceRespArray getProductsByProductType(String productTypeName);
}


