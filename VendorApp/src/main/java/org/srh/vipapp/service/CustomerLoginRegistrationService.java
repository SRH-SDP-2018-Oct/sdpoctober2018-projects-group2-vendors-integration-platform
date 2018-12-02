package org.srh.vipapp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Service Interface to perform the task related to Application Customers.  <br/>
 * Date: 01 Dec 2018
 * @author Vivek
 */
public interface CustomerLoginRegistrationService {

	/**
	 * Authenticates the Customer and returns the response in JSON
	 * @param req {@link HttpServletRequest}
	 * @param resp {@link HttpServletResponse}
	 * @param username {@link String}
	 * @param pwd {@link String}
	 * @return jsonObject {@link JSONObject}
	 */
	JSONObject authenticate(HttpServletRequest req, HttpServletResponse resp,
			String username, String pwd);

}
