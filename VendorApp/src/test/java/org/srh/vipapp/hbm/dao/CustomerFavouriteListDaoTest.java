package org.srh.vipapp.hbm.dao;

import static org.junit.Assert.*;
import org.junit.Test;
import org.srh.vipapp.hbm.dao.impl.CustomerFavouriteListDaoImpl;
import org.srh.vipapp.hbm.dto.CustomerFavouriteList;

public class CustomerFavouriteListDaoTest {

	@Test
	public void testFindById() {
		long id = 5;
		CustomerFavouriteList customerFavouriteList = new CustomerFavouriteListDaoImpl().findById(id);
		if (customerFavouriteList != null) {
			assertEquals(id, customerFavouriteList.getListId());
		} else {
			assertTrue(false);
		}
	}

	@Test
	public void testFindByCustomerId() {
		int CustomerId = 5;
		CustomerFavouriteList customerFavouriteList = new CustomerFavouriteListDaoImpl().findByCustomerId(CustomerId);
		if (customerFavouriteList != null) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}

}
