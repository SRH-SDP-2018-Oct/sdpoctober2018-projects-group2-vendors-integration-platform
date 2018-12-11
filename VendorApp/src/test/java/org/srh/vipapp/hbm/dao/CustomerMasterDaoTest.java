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
	public void testFindByValidIdLong() {
		long customerId = 1;
		CustomerMaster customerMaster = new CustomerMasterDaoImpl().findById(customerId);
		if (customerMaster != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
	
	@Test
	public void testFindByInvalidIdLong() {
		long customerId = 5;
		CustomerMaster customerMaster = new CustomerMasterDaoImpl().findById(customerId);
		if (customerMaster != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
	
	@Test
	public void testFindByNullIdLong() {
		long customerId = 0;
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
	public void testFindByValidIdLongSession() {
		long customerId = 1;
		CustomerMaster customerMaster = new CustomerMasterDaoImpl().findById(customerId);
		if (customerMaster != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
	
	@Test
	public void testFindByInvalidIdLongSession() {
		long customerId = 5;
		CustomerMaster customerMaster = new CustomerMasterDaoImpl().findById(customerId);
		if (customerMaster != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
	
	@Test
	public void testFindByNullIdLongSession() {
		long customerId = 0;
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
	public void testFindByValidUsername() {
		String username = "John";
		CustomerMaster customerMaster = new CustomerMasterDaoImpl().findByUsername(username);
		if (customerMaster != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
	
	@Test
	public void testFindByInvalidUsername() {
		String username = "Kate";
		CustomerMaster customerMaster = new CustomerMasterDaoImpl().findByUsername(username);
		if (customerMaster != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
	
	@Test
	public void testFindByNullUsername() {
		String username = null;
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
	public void testFindByValidName() {
		String name = "John";
		List<CustomerMaster> customerMaster = new CustomerMasterDaoImpl().findByName(name);
		if (customerMaster != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
	
	@Test
	public void testFindByInvalidName() {
		String name = "Kate";
		List<CustomerMaster> customerMaster = new CustomerMasterDaoImpl().findByName(name);
		if (customerMaster != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
	
	@Test
	public void testFindByNullName() {
		String name = null;
		List<CustomerMaster> customerMaster = new CustomerMasterDaoImpl().findByName(name);
		if (customerMaster != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

}
