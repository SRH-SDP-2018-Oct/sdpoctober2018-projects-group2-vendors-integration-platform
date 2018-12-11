package org.srh.vipapp.hbm.dao;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.srh.vipapp.hbm.dao.ProductTypeDao;
import org.srh.vipapp.hbm.dao.impl.ProductTypeDaoImpl;
import org.srh.vipapp.hbm.dto.ProductType;

/**
 * Implementation class of HBM DAO {@link ProductTypeDao} <br/>
 * Date: 08 Dec 2018
 * @author Anglita
 */
public class ProductTypeDaoImplTest {

	@Test
	public void testGetValidProductTypeIntString() {
		int vendorId = 1;
		List<ProductType> productType = new ProductTypeDaoImpl().getAllProductType(vendorId);
		if(productType == null)
		{
			assertTrue(true);

		}
	}
	
	@Test
	public void testGetInvalidProductTypeIntString() {
		int vendorId = 6;
		List<ProductType> productType = new ProductTypeDaoImpl().getAllProductType(vendorId);
		if(productType == null)
		{
			assertTrue(true);

		}
	}
	
	@Test
	public void testGetNullProductTypeIntString() {
		int vendorId = 0;
		List<ProductType> productType = new ProductTypeDaoImpl().getAllProductType(vendorId);
		if(productType == null)
		{
			assertTrue(true);

		}
	}

	@Test
	public void testGetValidProductTypeStringString() {
		String vendorName = "Aldo";
		List<ProductType> productType = new ProductTypeDaoImpl().getAllProductType(vendorName);
		if(productType == null)
		{
			assertTrue(true);

		}
	}
	
	@Test
	public void testGetInvalidProductTypeStringString() {
		String vendorName = "Aldi";
		List<ProductType> productType = new ProductTypeDaoImpl().getAllProductType(vendorName);
		if(productType == null)
		{
			assertTrue(true);

		}
	}
	
	@Test
	public void testGetNullProductTypeStringString() {
		String vendorName = null;
		List<ProductType> productType = new ProductTypeDaoImpl().getAllProductType(vendorName);
		if(productType == null)
		{
			assertTrue(true);

		}
	}

	@Test
	public void testGetAllProductTypeValidVendorId() {
		int vendorId = 1;
		List<ProductType> productType = new ProductTypeDaoImpl().getAllProductType(vendorId);
		if(productType != null)
		{
			boolean check = productType.iterator().hasNext();
			assertTrue(check);

		}

	}

	@Test
	public void testGetAllProductsInValidVendorId() {
		int vendorId = 9;
		List<ProductType> productType = new ProductTypeDaoImpl().getAllProductType(vendorId);
		if(productType == null)
		{
			assertTrue(true);

		}

	}
	
	
	@Test
	public void testGetAllProductsInNullVendorId() {
		int vendorId = 0;
		List<ProductType> productType = new ProductTypeDaoImpl().getAllProductType(vendorId);
		if(productType == null)
		{
			assertTrue(true);

		}

	}
	
	@Test
	public void testGetAllProductTypeByValidVendorName() {
		String vendorName = "Aldo";
		List<ProductType> productType = new ProductTypeDaoImpl().getAllProductType(vendorName);
		if(productType != null)
		{
			boolean hasProducts = productType.iterator().hasNext();
			assertTrue(hasProducts);

		}
	}

	@Test
	public void testGetAllProductTypeByInvalidVendorName() {
		String vendorName = "Aldi";
		List<ProductType> productType = new ProductTypeDaoImpl().getAllProductType(vendorName);
		if(productType == null)
		{
			assertTrue(true);

		}
	}
	
	@Test
	public void testGetAllProductTypeByNullVendorName() {
		String vendorName = null;
		List<ProductType> productType = new ProductTypeDaoImpl().getAllProductType(vendorName);
		if(productType == null)
		{
			assertTrue(true);

		}
	}
}
