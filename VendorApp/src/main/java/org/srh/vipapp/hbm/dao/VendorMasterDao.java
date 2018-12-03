/**
 * 
 */
package org.srh.vipapp.hbm.dao;

import java.util.List;

import org.srh.vipapp.hbm.dto.VendorMaster;

/**
 * HBM DAO to perform task related to {@link VendorMaster} entity.  <br/>
 * Date: 30 Nov 2018
 * @author Maitreyee
 */
public interface VendorMasterDao {
	
	/**
	 * Gets the {@link VendorMaster} entity with the given 'userId'.
	 * @param userId {@link Integer}
	 * @return userMaster {@link UserMaster}
	 */
	public VendorMaster findById(int userId);

	/**
	 * Returns all the {@link UserMaster} entities from persistence database
	 * @return vendorMasterList {@link List<VendorMaster>}
	 */
	public List<VendorMaster> getAllVendor();

	/**
	 * Gets the {@link VendorMaster} entity with the given 'vendorname'.
	 * @param vendorname {@link String}
	 * @return vendorMaster {@link VendorMaster}
	 */
	public VendorMaster findByVendorname(String vendorname);


}
