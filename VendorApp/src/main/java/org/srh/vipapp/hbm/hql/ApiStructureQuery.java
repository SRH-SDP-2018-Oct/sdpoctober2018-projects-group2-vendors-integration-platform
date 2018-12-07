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

	public static final String GET_API_STRUCTURE_OF_VENDOR_$P1 = "vendorId";
	public static final String GET_API_STRUCTURE_OF_VENDOR_$N = "GET_API_STRUCTURE_OF_VENDOR";
	public static final String GET_API_STRUCTURE_OF_VENDOR_$Q = "FROM ApiStructure "
			+ " WHERE deleteFlag=0 AND vendorId=:"+GET_API_STRUCTURE_OF_VENDOR_$P1;

}
