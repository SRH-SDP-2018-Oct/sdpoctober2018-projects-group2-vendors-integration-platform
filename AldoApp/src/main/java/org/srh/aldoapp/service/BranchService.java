package org.srh.aldoapp.service;

import org.srh.bean.ServiceRespArray;

/**
 * Service Interface to perform the task related to Vendor Branch.  <br/>
 * Date: 03 Dec 2018
 * @author Shraddha
 */

public interface BranchService {
	 /**
	 * Get all the branches located in the city.
	 * @param city {@link String}
	 * @return serviceRespArray {@link ServiceRespArray}
	 */
	ServiceRespArray getBranchesInCity(String city);

}

	

	


	



