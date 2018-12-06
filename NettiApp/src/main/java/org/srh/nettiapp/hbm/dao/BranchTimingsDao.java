package org.srh.nettiapp.hbm.dao;

import org.srh.nettiapp.hbm.dto.BranchTimings;

/**
 * HBM DAO to perform task related to {@link BranchMaster} entity.  <br/>
 * Date: 05 Dec 2018
 * @author yashas
 */

public interface BranchTimingsDao {

	/**
	 * Returns branchId the {@link BranchTimings} entities from persistence database
	 * 
	 * @return branchId {@link List<BranchTimings>}
	 */
	public BranchTimings findByBranchId(int branchId);

	/**
	 * Gets the {@link BranchTimings} entity with the given 'BranchTimings'.
	 * 
	 * @param BranchTimings
	 *            {@link String}
	 * @return BranchTimings {@link BranchTimings}
	 */
	public BranchTimings findTimingForTheDay(int dayInWeek);

}
