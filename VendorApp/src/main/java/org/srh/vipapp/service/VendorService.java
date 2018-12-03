package org.srh.vipapp.service;

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
	 * @return strJSON {@link String}
	 */
	String getVendorById(String vendorId);

}
