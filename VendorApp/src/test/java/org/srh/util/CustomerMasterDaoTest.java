package org.srh.util;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;
import org.srh.vipapp.hbm.dao.impl.CustomerMasterDaoImpl;
import org.srh.vipapp.hbm.dto.CustomerCart;
import org.srh.vipapp.hbm.dto.CustomerMaster;

public class CustomerMasterDaoTest {

	@Test
	public void testFindByIdLong() {
		long customerId = 1;
		List<CustomerMaster> customerMaster = new CustomerMasterDaoImpl().findByIdLong(customerId);
		if (customerMaster != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	@Test
	public void testFindByIdLongSession() {
	long customerId = 1;
	Session session;
	List<CustomerMaster> customerMaster = new CustomerMasterDaoImpl().findById(customerId,session);
	if(customerMaster != null)
	{
		assertTrue(true);
	}
	else
	{
		assertTrue(false);
	}

	@Test
	public void testGetAllCustomers() {

		List<CustomerMaster> customerMaster = new CustomerMasterDaoImpl().getAllCustomers();
		if (!customerMaster.isEmpty()) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	@Test
	public void testFindByUsername() {

		String username = "";
		CustomerMaster customerMaster = new CustomerMasterDaoImpl().findByUsername(username);
		if (customerMaster != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}

	@Test
	public void testFindByName() {
		String name = "";
		List<CustomerMaster> customerMaster = new CustomerMasterDaoImpl().findByName(name);
		if (!customerMaster.isEmpty()) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}

	@Test
	public void testSaveProduct() {
		CustomerCart customerCart;
		List<CustomerMaster> customerMaster = new CustomerMasterDaoImpl().saveProduct();
		if (customerMaster.isEmpty()) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}
}
