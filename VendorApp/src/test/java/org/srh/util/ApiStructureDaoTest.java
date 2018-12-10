/**
 * 
 */
package org.srh.util;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.srh.vipapp.hbm.dao.impl.ApiStructureDaoImpl;
import org.srh.vipapp.hbm.dto.ApiStructure;

/**
 * @author Maitreyee
 *
 */
public class ApiStructureDaoTest {

	/**
	 * Test method for {@link org.srh.vipapp.hbm.dao.ApiStructureDao#getApiStructureOfVendor(int)}.
	 */
	@Test
	public void testGetApiStructureOfValidVendorInt() {
		int vendorId = 2;
		List<ApiStructure> apiStructure = new ApiStructureDaoImpl().getApiStructureOfVendor(vendorId);
		if(apiStructure != null)
		{
			assertEquals(vendorId,apiStructure.get(2));
		}
	}
	
	@Test
	public void testGetApiStructureOfInvalidVendorInt() {
		int vendorId = 5;
		List<ApiStructure> apiStructure = new ApiStructureDaoImpl().getApiStructureOfVendor(vendorId);
		if(apiStructure == null)
		{
			assertEquals(null,apiStructure);
		}
	}

	/**
	 * Test method for {@link org.srh.vipapp.hbm.dao.ApiStructureDao#getApiStructureOfVendor(java.lang.String)}.
	 */
	@Test
	public void testGetApiStructureOfVendorString() {
		String vendorName = "";
		List<ApiStructure> apiStructure = new ApiStructureDaoImpl().getApiStructureOfVendor(vendorName);
		if(apiStructure != null)
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
	}

}
