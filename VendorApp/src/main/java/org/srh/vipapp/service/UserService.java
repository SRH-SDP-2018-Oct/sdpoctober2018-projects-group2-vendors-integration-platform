package org.srh.vipapp.service;

import org.json.JSONObject;

/**
 * Service Interface to perform the task related to Application Users.  <br/>
 * Date: 30 Nov 2018
 * @author Vivek
 */
public interface UserService {

	/**
	 * Returns user data as string in JSON format.
	 * @param userId {@link String}
	 * @return strJSON {@link String}
	 */
	String getUserById(String userId);
}
