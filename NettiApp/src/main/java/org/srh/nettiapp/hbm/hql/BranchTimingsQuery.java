package org.srh.nettiapp.hbm.hql;

public final class BranchTimingsQuery {
	public BranchTimingsQuery() {}
	
	public static final String FIND_BRANCH_BY_BRANCHID_$P1 = "branchId";
	public static final String FIND_BRANCH_BY_BRANCHID_$N = "FIND_BRANCH_BY_BRANCHID";
	public static final String FIND_BRANCH_BY_BRANCHID_$Q = "FROM BranchTimings "
			+ " WHERE deleteFlag=0 AND branchId=:"+FIND_BRANCH_BY_BRANCHID_$P1;

	public static final String FIND_BRANCH_BY_DAYINWEEK_$P1 = "dayInWeek";
	public static final String FIND_BRANCH_BY_DAYINWEEK_$N = "FIND_BRANCH_BY_DAYINWEEK";
	public static final String FIND_BRANCH_BY_DAYINWEEK_$Q = "FROM BranchTimings "
			+ " WHERE firstName LIKE :"+FIND_BRANCH_BY_DAYINWEEK_$P1;
}
