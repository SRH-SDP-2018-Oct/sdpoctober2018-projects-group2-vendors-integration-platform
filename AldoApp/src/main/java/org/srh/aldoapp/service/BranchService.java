package org.srh.aldoapp.service;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Service Interface to perform the task related to Vendor Branch.  <br/>
 * Date: 03 Dec 2018
 * @author Shraddha
 */

public interface BranchService {
	 /**
	 * Get all the branches located in the city.
	 * @param resp {@link HttpServletResponse}
	 * @param city {@link String}
	 * @return jsonData {@link JSONObject}
	 */
	JSONObject getBranchesInCity(HttpServletResponse resp, String city);

}

	

	


	



