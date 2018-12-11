/**
 * 
 */
package org.srh.vipapp.hbm.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.srh.vipapp.hbm.dao.impl.CustomerMasterDaoImpl;
import org.srh.vipapp.hbm.dto.CustomerMaster;

public class CustomerMasterDaoTest {

	/**
	 * Test method for {@link org.srh.vipapp.hbm.dao.CustomerMasterDao#findById(long)}.
	 */
	@Test
	public void testFindByIdLong() {
		long customerId = 1;
		CustomerMaster customerMaster = new CustomerMasterDaoImpl().findById(customerId);
		if (customerMaster != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	/**
	 * Test method for {@link org.srh.vipapp.hbm.dao.CustomerMasterDao#findById(long, org.hibernate.Session)}.
	 */
	@Test
	public void testFindByIdLongSession() {
		long customerId = 1;
		CustomerMaster customerMaster = new CustomerMasterDaoImpl().findById(customerId);
		if (customerMaster != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	/**
	 * Test method for {@link org.srh.vipapp.hbm.dao.CustomerMasterDao#getAllCustomers()}.
	 */
	@Test
	public void testGetAllCustomers() {
		List<CustomerMaster> customerMaster = new CustomerMasterDaoImpl().getAllCustomers();
		if (customerMaster != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	/**
	 * Test method for {@link org.srh.vipapp.hbm.dao.CustomerMasterDao#findByUsername(java.lang.String)}.
	 */
	@Test
	public void testFindByUsername() {
		String username = "John";
		CustomerMaster customerMaster = new CustomerMasterDaoImpl().findByUsername(username);
		if (customerMaster != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	/**
	 * Test method for {@link org.srh.vipapp.hbm.dao.CustomerMasterDao#findByName(java.lang.String)}.
	 */
	@Test
	public void testFindByName() {
		String name = "John";
		List<CustomerMaster> customerMaster = new CustomerMasterDaoImpl().findByName(name);
		if (customerMaster != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
}
