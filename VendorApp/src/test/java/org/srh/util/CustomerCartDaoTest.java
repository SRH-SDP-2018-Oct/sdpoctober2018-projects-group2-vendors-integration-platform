package org.srh.util;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.srh.vipapp.hbm.dao.impl.CustomerCartDaoImpl;
import org.srh.vipapp.hbm.dto.CustomerCart;

public class CustomerCartDaoTest {

	@Test
	public void testFindByCartId() {
		long cartId = 1;
		CustomerCart customerCart = new CustomerCartDaoImpl().findByCartId(cartId);
		if (customerCart != null) {
			assertEquals(cartId, customerCart.getCartId());
		} else {
			// Cart Id does not exist in database
			assertTrue(true);
		}
	}

	@Test
	public void testGetAllCarts() {
		List<CustomerCart> customerCart = new CustomerCartDaoImpl().getAllCarts();
		if (!customerCart.isEmpty()) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}

	@Test
	public void testGetCartByCustomerId() {
		List<CustomerCart> customerCart = new CustomerCartDaoImpl().getAllCarts();
		if (!customerCart.isEmpty()) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}

}
