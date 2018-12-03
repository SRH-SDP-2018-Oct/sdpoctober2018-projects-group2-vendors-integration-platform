/**
 * 
 */
package org.srh.vipapp.hbm.hql;

public class VendorMasterQuery {
	
	private VendorMasterQuery() { }

	public static final String GET_ALL_VENDOR_$N = "GET_ALL_VENDOR";
	public static final String GET_ALL_VENDOR_$Q = "FROM VendorMaster WHERE deleteFlag=0";

	public static final String FIND_VENDOR_BY_VENDORNAME_$P1 = "vendorName";
	public static final String FIND_VENDOR_BY_VENDORNAME_$N = "FIND_VENDOR_BY_VENDORNAME";
	public static final String FIND_VENDOR_BY_VENDORNAME_$Q = "FROM VendorMaster WHERE deleteFlag=0 AND vendorName=:" + FIND_VENDOR_BY_VENDORNAME_$P1;


}
