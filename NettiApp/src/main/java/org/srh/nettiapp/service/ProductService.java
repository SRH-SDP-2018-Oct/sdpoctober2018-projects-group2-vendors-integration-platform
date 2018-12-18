package org.srh.nettiapp.service;

import org.srh.bean.ServiceRespArray;

/**
 * Service Interface to perform the task related to Application Products. <br/>
 * Date: 05 Dec 2018
 * 
 * @author Shraddha
 */
public interface ProductService {


	/**
	 * Returns all the product data.
	 * 
	 * @param productId {@link String}
	 * @return serviceResp {@link ServiceResp}
	 */
	ServiceRespArray getAllProducts();

}
