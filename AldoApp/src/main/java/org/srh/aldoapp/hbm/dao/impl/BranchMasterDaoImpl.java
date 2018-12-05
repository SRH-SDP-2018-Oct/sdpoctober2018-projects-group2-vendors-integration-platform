package org.srh.aldoapp.hbm.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.srh.aldoapp.hbm.RootHB;
import org.srh.aldoapp.hbm.dao.BranchMasterDao;
import org.srh.aldoapp.hbm.dto.BranchMaster;
import org.srh.aldoapp.hbm.hql.BranchMasterQuery;

/**
 * Implementation class of HBM DAO {@link BranchMasterDao} Date: 0 Dec 2018
 * 
 * @author Shraddha
 */

public class BranchMasterDaoImpl implements BranchMasterDao {

	@Override
	public List<BranchMaster> getBranchesInCity(String city) {
		try (Session session = RootHB.getSessionFactory().openSession();) {
			@SuppressWarnings("unchecked")
			Query<BranchMaster> query = session.createNamedQuery(BranchMasterQuery.GET_ALL_BRANCHES_IN_CITY_$N);
			query.setParameter(BranchMasterQuery.GET_ALL_BRANCHES_IN_CITY_$P1, city);
			return query.getResultList();
		}
	}
}
