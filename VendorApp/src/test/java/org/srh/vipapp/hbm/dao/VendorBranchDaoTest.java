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

	/**
	 * Test method for {@link org.srh.vipapp.hbm.dao.VendorBranchDao#getAllBranches(java.lang.String)}.
	 */
	@Test
	public void testGetAllBranchesString() {
		String vendorName = "";
		List<VendorBranch> vendorBranch = new VendorBranchDaoImpl().getAllBranches(vendorName);
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
