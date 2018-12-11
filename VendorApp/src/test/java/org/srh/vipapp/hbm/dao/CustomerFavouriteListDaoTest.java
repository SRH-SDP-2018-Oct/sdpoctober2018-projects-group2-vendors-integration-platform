package org.srh.vipapp.hbm.dao;

import static org.junit.Assert.*;
import org.junit.Test;
import org.srh.vipapp.hbm.dao.impl.CustomerFavouriteListDaoImpl;
import org.srh.vipapp.hbm.dto.CustomerFavouriteList;

public class CustomerFavouriteListDaoTest {

	@Test
	public void testFindByValidId() {
		long id = 1;
		CustomerFavouriteList customerFavouriteList = new CustomerFavouriteListDaoImpl().findById(id);
		if (customerFavouriteList != null) {
			assertEquals(id, customerFavouriteList.getListId());
		} else {
			assertTrue(false);
		}
	}
	
	@Test
	public void testFindByInvalidId() {
		long id = 5;
		CustomerFavouriteList customerFavouriteList = new CustomerFavouriteListDaoImpl().findById(id);
		if (customerFavouriteList != null) {
			assertEquals(id, customerFavouriteList.getListId());
		} else {
			assertTrue(false);
		}
	}
	
	@Test
	public void testFindByNullId() {
		long id = 0;
		CustomerFavouriteList customerFavouriteList = new CustomerFavouriteListDaoImpl().findById(id);
		if (customerFavouriteList != null) {
			assertEquals(id, customerFavouriteList.getListId());
		} else {
			assertTrue(false);
		}
	}
	
	@Test
	public void testFindByValidCustomerId() {
		int CustomerId = 1;
		CustomerFavouriteList customerFavouriteList = new CustomerFavouriteListDaoImpl().findByCustomerId(CustomerId);
		if (customerFavouriteList != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}

	@Test
	public void testFindByInvalidCustomerId() {
		int CustomerId = 5;
		CustomerFavouriteList customerFavouriteList = new CustomerFavouriteListDaoImpl().findByCustomerId(CustomerId);
		if (customerFavouriteList != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}
	
	@Test
	public void testFindByNullCustomerId() {
		int CustomerId = 0;
		CustomerFavouriteList customerFavouriteList = new CustomerFavouriteListDaoImpl().findByCustomerId(CustomerId);
		if (customerFavouriteList != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}

}
