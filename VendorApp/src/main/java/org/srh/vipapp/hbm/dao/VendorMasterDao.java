/**
 * 
 */
package org.srh.vipapp.hbm.dao;

import java.util.List;

import org.hibernate.Session;
import org.srh.vipapp.hbm.dto.VendorMaster;

/**
 * HBM DAO to perform task related to {@link VendorMaster} entity.  <br/>
 * Date: 30 Nov 2018
 * @author Maitreyee
 */
public interface VendorMasterDao {

	/**
	 * Gets the {@link VendorMaster} entity with the given 'userId'.
	 * @param vendorId {@link Integer}
	 * @param session {@link Session}
	 * @return vendorMaster {@link VendorMaster}
	 */
	VendorMaster findById(int vendorId, Session session);
	
	/**
	 * Gets the {@link VendorMaster} entity with the given 'userId'.
	 * @param vendorId {@link Integer}
	 * @return vendorMaster {@link VendorMaster}
	 */
	VendorMaster findById(int vendorId);

	/**
	 * Returns all the {@link VendorMaster} entities from persistence database
	 * @return vendorMasterList {@link List<VendorMaster>}
	 */
	List<VendorMaster> getAllVendors();

	/**
	 * 
	 * Gets the {@link VendorMaster} entity with the given 'vendorName'.
	 * @param vendorName {@link String}
	 * @param session {@link Session}
	 * @return vendorMaster {@link VendorMaster}
	 */
	VendorMaster findByVendorName(String vendorname, Session session);

	/**
	 * Gets the {@link VendorMaster} entity with the given 'vendorName'.
	 * @param vendorName {@link String}
	 * @return vendorMaster {@link VendorMaster}
	 */
	VendorMaster findByVendorName(String vendorName);


}
