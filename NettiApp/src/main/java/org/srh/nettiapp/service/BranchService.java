package org.srh.nettiapp.service;

import javax.servlet.http.HttpServletResponse;

import org.srh.bean.ServiceRespArray;

/**
 * Service Interface to perform the task related to Vendor Branch.  <br/>
 * Date: 02 Dec 2018
 * @author Vivek
 */
public interface BranchService {

	/**
	 * Get all the branches located in the city.
	 * @param resp {@link HttpServletResponse}
	 * @param city {@link String}
	 * @return serviceRespArray {@link ServiceRespArray}
	 */
	ServiceRespArray getBranchesInCity(String city);

}
