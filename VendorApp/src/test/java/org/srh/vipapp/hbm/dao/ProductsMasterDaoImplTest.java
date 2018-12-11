package org.srh.vipapp.hbm.dao;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.srh.vipapp.hbm.dao.impl.ProductsMasterDaoImpl;
import org.srh.vipapp.hbm.dto.ProductsMaster;

public class ProductsMasterDaoImplTest {

	@Test
	public void testFindByValidId() {
		int productId = 1;
		ProductsMaster productMaster = new ProductsMasterDaoImpl().findById(productId);
		if(productMaster != null)
		{
			assertEquals(productId,productMaster.getProductId());
		}
	}
	@Test
	public void testFindByInvalidId() {
		int productId = 9;
		ProductsMaster productMaster = new ProductsMasterDaoImpl().findById(productId);
		if(productMaster == null)
		{
			assertEquals(null,productMaster);
		}
	}
	
	@Test
	public void testFindByNullId() {
		int productId = 0;
		ProductsMaster productMaster = new ProductsMasterDaoImpl().findById(productId);
		if(productMaster == null)
		{
			assertEquals(null,productMaster);
		}
	}

	@Test
	public void testGetAllProducts() {
		List<ProductsMaster> productMaster = new ProductsMasterDaoImpl().getAllProducts();
		if(!productMaster.isEmpty())
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}


	}

	@Test
	public void testFindbyValidProductName() {
		String productName = "Milk";
		List<ProductsMaster> productMaster = new ProductsMasterDaoImpl().findbyProductName(productName);
		if(productMaster != null)
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
	}
	
	@Test
	public void testFindbyInvalidProductName() {
		String productName = "Chocolate";
		List<ProductsMaster> productMaster = new ProductsMasterDaoImpl().findbyProductName(productName);
		if(productMaster != null)
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
	}
	
	@Test
	public void testFindbyNullProductName() {
		String productName = null;
		List<ProductsMaster> productMaster = new ProductsMasterDaoImpl().findbyProductName(productName);
		if(productMaster != null)
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
	}

	@Test
	public void testGetProductsByValidProductType() {
		String productType = "Dairy";
		List<ProductsMaster> productsMaster = new ProductsMasterDaoImpl().getProductsByProductType(productType);
		if(productsMaster != null)
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetProductsByInvalidProductType() {
		String productType = "Bakery";
		List<ProductsMaster> productsMaster = new ProductsMasterDaoImpl().getProductsByProductType(productType);
		if(productsMaster != null)
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetProductsByNullProductType() {
		String productType = null;
		List<ProductsMaster> productsMaster = new ProductsMasterDaoImpl().getProductsByProductType(productType);
		if(productsMaster != null)
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
	}

	@Test
	public void testGetAllProductsOnOffer() {
		List<ProductsMaster> productsMaster = new ProductsMasterDaoImpl().getAllProductsOnOffer();
		if(productsMaster != null)
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
	}

}
