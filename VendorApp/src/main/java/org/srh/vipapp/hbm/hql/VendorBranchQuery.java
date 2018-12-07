package org.srh.vipapp.hbm.hql;

public final class VendorBranchQuery {

	private VendorBranchQuery() {}

	public static final String GET_ALL_VENDOR_BRANCHES_$P1 = "vendorId";
	public static final String GET_ALL_VENDOR_BRANCHES_$N = "GET_ALL_VENDOR_BRANCHES";
	public static final String GET_ALL_VENDOR_BRANCHES_$Q = "FROM VendorBranch "
			+ " WHERE deleteFlag=0 AND vendorId=:"+GET_ALL_VENDOR_BRANCHES_$P1;
}
