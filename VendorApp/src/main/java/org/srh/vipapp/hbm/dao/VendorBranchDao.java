package org.srh.vipapp.hbm.dao;

import java.util.List;

import org.srh.vipapp.hbm.dto.VendorBranch;

/**
 * HBM DAO to perform task related to {@link VendorBranch} entity.  <br/>
 * Date: 07 Dec 2018
 * @author Vivek
 */
public interface VendorBranchDao {

	/**
	 * Returns all the {@link VendorBranch} entities from persistence database
	 * associated to the given vendor id.
	 * @param vendorId {@link Integer}
	 * @return productsMasterList {@link List<VendorBranch>}
	 */
	List<VendorBranch> getAllBranches(int vendorId);

	/**
	 * Returns all the {@link VendorBranch} entities from persistence database
	 * associated to the given vendor name.
	 * @param vendorName {@link String}
	 * @return productsMasterList {@link List<VendorBranch>}
	 */
	List<VendorBranch> getAllBranches(String vendorName);
	
}
