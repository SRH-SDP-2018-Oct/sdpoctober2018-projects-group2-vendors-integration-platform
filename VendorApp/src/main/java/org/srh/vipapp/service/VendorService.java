package org.srh.vipapp.service;

import org.srh.bean.ServiceResp;
import org.srh.bean.ServiceRespArray;

/**
 * Service Interface to perform the task related to Application Vendors.  <br/>
 * Date: 30 Nov 2018
 * @author Maitreyee
 *
 */

public interface VendorService {

	/**
	 * Returns vendor data as string in JSON format.
	 * @param vendorId {@link String}
	 * @return serviceResp {@link ServiceResp}
	 */
	ServiceResp getVendorById(String vendorId);

	/**
	 * Returns the user data of the given vendorName.
	 * @param vendorName {@link String}
	 * @return serviceResp {@link ServiceResp}
	 */
	ServiceResp getVendorByVendorName(String vendorName);

	/**
	 * Returns all the vendors.
	 * @return serviceRespArray {@link ServiceRespArray}
	 */
	ServiceRespArray getAllVendors();

}
