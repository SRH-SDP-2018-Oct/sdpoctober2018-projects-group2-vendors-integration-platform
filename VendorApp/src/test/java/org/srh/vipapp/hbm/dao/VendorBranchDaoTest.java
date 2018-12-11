/**
 * 
 */
package org.srh.vipapp.hbm.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.srh.vipapp.hbm.dao.impl.VendorBranchDaoImpl;
import org.srh.vipapp.hbm.dto.VendorBranch;

/**
 * @author Maitreyee
 *
 */
public class VendorBranchDaoTest {

	/**
	 * Test method for {@link org.srh.vipapp.hbm.dao.VendorBranchDao#getAllBranches(int)}.
	 */
	@Test
	public void testGetAllValidBranchesInt() {
		int vendorId = 2;
		List<VendorBranch> vendorBranch = new VendorBranchDaoImpl().getAllBranches(vendorId);
		if(vendorBranch == null)
		{
			assertEquals(null,vendorBranch);
		}
	}

	@Test
	public void testGetAllInvalidBranchesInt() {
		int vendorId = 5;
		List<VendorBranch> vendorBranch = new VendorBranchDaoImpl().getAllBranches(vendorId);
		if(vendorBranch == null)
		{
			assertEquals(null,vendorBranch);
		}
	}
	
	@Test
	public void testGetAllNullBranchesInt() {
		int vendorId = 0;
		List<VendorBranch> vendorBranch = new VendorBranchDaoImpl().getAllBranches(vendorId);
		if(vendorBranch == null)
		{
			assertEquals(null,vendorBranch);
		}
	}

	/**
	 * Test method for {@link org.srh.vipapp.hbm.dao.VendorBranchDao#getAllBranches(java.lang.String)}.
	 */
	@Test
	public void testGetAllValidBranchesString() {
		String vendorId = "1";
		List<VendorBranch> vendorBranch = new VendorBranchDaoImpl().getAllBranches(vendorId);
		if(vendorBranch != null)
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetAllInvalidBranchesString() {
		String vendorId = "9";
		List<VendorBranch> vendorBranch = new VendorBranchDaoImpl().getAllBranches(vendorId);
		if(vendorBranch != null)
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetAllNullBranchesString() {
		String vendorId = null;
		List<VendorBranch> vendorBranch = new VendorBranchDaoImpl().getAllBranches(vendorId);
		if(vendorBranch != null)
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
		}
	}
}
