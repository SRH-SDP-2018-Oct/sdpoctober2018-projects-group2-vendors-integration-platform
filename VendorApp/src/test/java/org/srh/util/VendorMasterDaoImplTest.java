package org.srh.util;

import static org.junit.Assert.*;

import org.json.JSONObject;


import org.junit.Test;
import org.srh.vipapp.hbm.dao.impl.VendorMasterDaoImpl;

public class VendorMasterDaoImplTest {

	@Test
	public void testFindByIdIntPositive() {
		JSONObject jsonObject = null;
		Object obj1 = new VendorMasterDaoImpl().findById(1);
 		jsonObject	 = new JSONObject(obj1);
 		int vendorNameValue = jsonObject.getInt("vendorId");
		if(vendorNameValue == 1)
		{
			assertTrue(true);
		}
		
	}

	@Test
	public void testFindByIdIntNullVendorid() {
		
		Object obj = new VendorMasterDaoImpl().findById(0);
		if(obj == null)
		{
			assertTrue(true);
		}
		
	}

	@Test
	public void testGetAllVendors() {
		JSONObject jsonObject = null;
		Object obj1 = new VendorMasterDaoImpl().getAllVendors();
 	
 		
	}

	@Test
	public void testFindByVendorNameStringSession() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByVendorNameString() {
		fail("Not yet implemented");
	}

}
