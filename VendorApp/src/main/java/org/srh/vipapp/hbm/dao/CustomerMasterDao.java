package org.srh.vipapp.hbm.dao;

import java.util.List;

import org.srh.vipapp.hbm.dto.CustomerMaster;


/**
 * HBM DAO to perform task related to {@link CustomerMaster} entity.  <br/>
 * Date: 01 Dec 2018
 * @author Vivek
 */
public interface CustomerMasterDao {

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
	
	//MAITREYEE
	/**
	 * Registers the {@link CustomerMaster} new customer by input values username, firstname, lastname and pwd.
	 * @param name {@link String}
	 * @return customerMaster {@link List<CustomerMaster>}
	 */
	public int registerCustomer(CustomerMaster customerMaster);
}
