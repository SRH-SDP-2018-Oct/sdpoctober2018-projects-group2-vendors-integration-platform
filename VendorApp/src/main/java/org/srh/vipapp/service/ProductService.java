package org.srh.vipapp.service;

import org.srh.bean.ServiceResp;
import org.srh.bean.ServiceRespArray;

/**
 * Service Interface to perform the task related to Application Products.  <br/>
 * Date: 04 Dec 2018
 * @author Yashas
 */
public interface ProductService {
	
	

		/**
		 * Returns product data with the given ProductId.
		 * @param productId {@link String}
		 * @return serviceResp {@link ServiceResp}
		 */
		ServiceResp	getProductByproductId(String productId);

		/**
		 * Returns the offers data of the given offersId.
		 * @param customerUsername {@link String}
		 * @return serviceResp {@link ServiceResp}
		 */
		ServiceResp getoffersByoffersId(String offersId);

		/**
		 * Returns the product type data with the given productTypeId.
		 * @param productTypeId {@link String}
		 * @return serviceRespArray {@link ServiceRespArray}
		 */
		ServiceRespArray getproducttypeByproductTypeId(String productTypeId);
	}


