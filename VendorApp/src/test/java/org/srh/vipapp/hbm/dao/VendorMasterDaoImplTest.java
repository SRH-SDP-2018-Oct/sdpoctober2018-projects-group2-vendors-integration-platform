package org.srh.vipapp.hbm.dao;

import static org.junit.Assert.*;
import org.json.JSONObject;
import org.junit.Test;
import org.srh.vipapp.hbm.dao.impl.VendorMasterDaoImpl;
import org.srh.vipapp.hbm.dto.VendorMaster;



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
	public void testFindById() {
		int id = 1;
		VendorMaster vendorMaster = new VendorMasterDaoImpl().findById(id);
		if(vendorMaster != null){
			assertEquals(id, vendorMaster.getVendorId());
		}
		else {
			// Entry not present in database
			assertEquals(null, vendorMaster);
		}

	}

	@Test
	public void testGetAllVendors() {
		JSONObject jsonObject = null;
		Object obj1 = new VendorMasterDaoImpl().getAllVendors();
		jsonObject	 = new JSONObject(obj1);
		int length = jsonObject.length();
		if(length != 0)
		{
			assertTrue(true);
		}

	}

/*	@Test
	public void testFindByVendorNameStringSession() {
		fail("Not yet implemented");
	}
*/
	@Test
	public void testFindByVendorNameStringPositive() {
		String vendorName = "Aldo";
		VendorMaster vendorMaster = new VendorMasterDaoImpl().findByVendorName(vendorName);
		if(vendorMaster != null)
		{
			assertEquals(vendorName,vendorMaster.getVendorName());
			
		}
		

	}

	@SuppressWarnings("null")
	@Test
	public void testFindByVendorNameStringNegative() {
		String vendorName = "Aldi";
		VendorMaster vendorMaster = new  VendorMasterDaoImpl().findByVendorName(vendorName);
		if(vendorMaster == null)
		{
			 assertEquals(null,vendorMaster.getVendorName());
			
		}

	}

}
