package org.srh.vipapp.service;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Service Interface to perform the task related to Application Users.  <br/>
 * Date: 30 Nov 2018
 * @author Vivek
 */
public interface UserService {

	/**
	 * Returns user data enclosed in JSONObject of the given userId.
	 * @param userId {@link String}
	 * @param response {@link HttpServletResponse}
	 * @return jsonObject {@link JSONObject}
	 */
	JSONObject getUserById(String userId, HttpServletResponse response);

}
