package org.srh.aldoapp.hbm.hql;

import org.srh.aldoapp.hbm.dto.BranchMaster;
/**
 * Contains HQL for the {@link BranchMaster} entity.
 * Date: 05 Dec 2018
 * @author Shraddha
 */

public class BranchMasterQuery {
	

		private BranchMasterQuery() {}

		public static final String GET_ALL_BRANCHES_IN_CITY_$P1 = "userName";
		public static final String GET_ALL_BRANCHES_IN_CITY_$N = "GET_ALL_BRANCHES_IN_CITY";
		public static final String GET_ALL_BRANCHES_IN_CITY_$Q = "FROM BranchMaster "
				+ " WHERE deleteFlag=0 AND city=:" + GET_ALL_BRANCHES_IN_CITY_$P1;

	}

