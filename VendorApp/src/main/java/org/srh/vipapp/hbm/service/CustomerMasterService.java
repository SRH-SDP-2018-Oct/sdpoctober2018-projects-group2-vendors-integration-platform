package org.srh.vipapp.hbm.service;

import java.util.List;

import org.srh.vipapp.hbm.dto.CustomerMaster;

/**
 * HBM Service to perform task related to {@link CustomerMaster} entity.  <br/>
 * Date: 01 Nov 2018
 * @author Vivek
 */
public interface CustomerMasterService {

	/**
	 * Gets the {@link CustomerMaster} entity with the given 'customerId'.
	 * @param customerId {@link Long}
	 * @return customerMaster {@link CustomerMaster}
	 */
	public CustomerMaster findById(long customerId);

	/**
	 * Returns all the {@link CustomerMaster} entities from persistence database
	 * @return customerMasterList {@link List<CustomerMaster>}
	 */
	public List<CustomerMaster> getAllCustomers();

	/**
	 * Gets the {@link CustomerMaster} entity with the given 'username'.
	 * @param username {@link String}
	 * @return customerMaster {@link CustomerMaster}
	 */
	public CustomerMaster findByUsername(String username);

	/**
	 * Gets the {@link CustomerMaster} entities with the given first name or the last name.
	 * @param name {@link String}
	 * @return customerMaster {@link List<CustomerMaster>}
	 */
	public List<CustomerMaster> findByName(String name);

}
