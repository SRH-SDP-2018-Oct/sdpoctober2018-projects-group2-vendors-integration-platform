package org.srh.aldoapp.hbm.dao;


	/**
	 * HBM DAO to perform task related to {@link BranchMaster} entity.  <br/>
	 * Date: 05 Dec 2018
	 * @author yashas
	 */


		import org.srh.aldoapp.hbm.dto.BranchTimings;


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
