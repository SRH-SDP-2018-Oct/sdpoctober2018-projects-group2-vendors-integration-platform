/**
 * 
 */
package org.srh.vipapp.hbm.hql;

/**
 * @author Maitreyee
 *
 */
public class ApiStructureQuery {
	
	private ApiStructureQuery() {}

	public static final String GET_ALL_VENDOR_API_$P1 = "vendorId";
	public static final String GET_ALL_VENDOR_API_$N = "GET_ALL_VENDOR_API";
	public static final String GET_ALL_VENDOR_API_$Q = "FROM ApiStructure "
			+ " WHERE deleteFlag=0 AND vendorId=:"+GET_ALL_VENDOR_API_$P1;

}
