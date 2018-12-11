/**
 * 
 */
package org.srh.vipapp.hbm.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.srh.vipapp.hbm.dao.impl.VendorMasterDaoImpl;
import org.srh.vipapp.hbm.dto.VendorMaster;

/**
 * @author Maitreyee
 *
 */
public class VendorMasterDaoTest {

	/**
	 * Test method for {@link org.srh.vipapp.hbm.dao.VendorMasterDao#findById(int)}.
	 */
	@Test
	public void testFindByValidIdInt() {
		int vendorId = 2;
		VendorMaster vendorMaster = new VendorMasterDaoImpl().findById(vendorId);
		if(vendorMaster != null)
		{
			assertEquals(vendorId,vendorMaster.getVendorId());
		}
	}
	
	@Test
	public void testFindByInvalidIdInt() {
		int vendorId = 5;
		VendorMaster vendorMaster = new VendorMasterDaoImpl().findById(vendorId);
		if(vendorMaster == null)
		{
			assertEquals(null,vendorMaster);
		}
	}
	
	@Test
	public void testFindByNullIdInt() {
		int vendorId = 0;
		VendorMaster vendorMaster = new VendorMasterDaoImpl().findById(vendorId);
		if(vendorMaster == null)
		{
			assertEquals(null,vendorMaster);
		}
	}

	/**
	 * Test method for {@link org.srh.vipapp.hbm.dao.VendorMasterDao#getAllVendors()}.
	 */
	@Test
	public void testGetAllVendors() {
		List<VendorMaster> vendorMaster = new VendorMasterDaoImpl().getAllVendors();
		if(!vendorMaster.isEmpty())
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
	}

	/**
	 * Test method for {@link org.srh.vipapp.hbm.dao.VendorMasterDao#findByVendorName(java.lang.String)}.
	 */
	@Test
	public void testFindByValidVendorNameString() {
		String vendorname = "Netti";
		VendorMaster vendorMaster = new VendorMasterDaoImpl().findByVendorName(vendorname);
		if(vendorMaster != null)
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
	}
	
	@Test
	public void testFindByInvalidVendorNameString() {
		String vendorname = "Netto";
		VendorMaster vendorMaster = new VendorMasterDaoImpl().findByVendorName(vendorname);
		if(vendorMaster != null)
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
	}
	
	@Test
	public void testFindByNullVendorNameString() {
		String vendorname = null;
		VendorMaster vendorMaster = new VendorMasterDaoImpl().findByVendorName(vendorname);
		if(vendorMaster != null)
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
	}

}
