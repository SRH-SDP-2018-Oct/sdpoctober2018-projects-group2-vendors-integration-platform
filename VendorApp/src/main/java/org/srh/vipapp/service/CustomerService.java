package org.srh.vipapp.service;

import org.srh.bean.ServiceResp;
import org.srh.bean.ServiceRespArray;

/**
 * Service Interface to perform the task related to Application Customers.  <br/>
 * Date: 01 Dec 2018
 * @author Vivek
 */
public interface CustomerService {

	/**
	 * Returns customer data with the given customerId.
	 * @param userId {@link String}
	 * @return serviceResp {@link ServiceResp}
	 */
	ServiceResp	getCustomerById(String customerId);

	/**
	 * Returns the user data of the given username.
	 * @param customerUsername {@link String}
	 * @return serviceResp {@link ServiceResp}
	 */
	ServiceResp getCustomersByUsername(String customerUsername);

	/**
	 * Returns the customer data with the given name.
	 * @param customerName {@link String}
	 * @return serviceRespArray {@link ServiceRespArray}
	 */
	ServiceRespArray getCustomersByName(String customerName);
}
