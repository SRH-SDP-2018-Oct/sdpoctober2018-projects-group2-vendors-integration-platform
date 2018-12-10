package org.srh.util;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.srh.aldoapp.hbm.dao.impl.ProductMasterDaoImpl;
import org.srh.aldoapp.hbm.dto.ProductMaster;

public class ProductMasterDaoTest {

	@Test
	public void testGetAllProducts() {
		List<ProductMaster> productMaster = new ProductMasterDaoImpl().getAllProducts();
		if (!productMaster.isEmpty()) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}

}
