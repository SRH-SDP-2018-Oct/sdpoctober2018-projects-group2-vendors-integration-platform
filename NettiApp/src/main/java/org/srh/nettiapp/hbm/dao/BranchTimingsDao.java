package org.srh.nettiapp.hbm.dao;


/**
 * HBM DAO to perform task related to {@link UserMaster} entity.  <br/>
 * Date: 05 Dec 2018
 * @author yashas
 */


	import org.srh.nettiapp.hbm.dto.BranchTimings;


	public interface BranchTimingsDao {

		/**
		 * Returns branchId the {@link BranchTimings} entities from persistence database
		 * @return branchId {@link List<BranchTimings>}
		 */
		public BranchTimingsDao findbybranchId(int branchId);

		/**
		 * Gets the {@link BranchTimings} entity with the given 'BranchTimings'.
		 * @param BranchTimings {@link String}
		 * @return BranchTimings {@link BranchTimings}
		 */
		public BranchTimingsDao findBydayInWeek(int dayInWeek);

	
}
