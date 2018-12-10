package org.srh.vipapp.service;

import org.srh.bean.ServiceResp;

/**
 * Service Interface to perform the task related to Application Customers.  <br/>
 * Date: 01 Dec 2018
 * @author Vivek
 */
public interface CustomerLoginRegistrationService {

	/**
	 * Authenticates the Customer and returns the response
	 * @param username {@link String}
	 * @param pwd {@link String}
	 * @return serviceResp {@link ServiceResp}
	 */
	ServiceResp authenticate(String username, String pwd);
	
	//MAITREYEE	
	/**
	 * Registers the new customer and save its record to DB.
	 * @param username {@link String}
	 * @param firstName {@link String}
	 * @param lastName {@link String}
	 * @param pwd {@link String}
	 * @return serviceResp {@link ServiceResp}
	 */
	ServiceResp setCustomerDetails(String username, String firstName, String lastName, String pwd);

}
