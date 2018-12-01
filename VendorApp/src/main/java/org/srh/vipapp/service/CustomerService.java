package org.srh.vipapp.service;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Service Interface to perform the task related to Application Customers.  <br/>
 * Date: 01 Dec 2018
 * @author Vivek
 */
public interface CustomerService {

	/**
	 * Returns customer data in JSONObject with the given customerId.
	 * @param userId {@link String}
	 * @param response {@link HttpServletResponse}
	 * @return jsonObject {@link JSONObject}
	 */
	JSONObject getCustomerById(HttpServletResponse response, String customerId);

	/**
	 * Returns the customer data in JSONArray with the given name.
	 * @param resp {@link HttpServletResponse}
	 * @param customerName {@link String}
	 * @return jsonObject {@link JSONObject}
	 */
	JSONObject getCustomersByName(HttpServletResponse resp, String customerName);

}
