package org.srh.nettiapp.hbm.dao.impl;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.srh.nettiapp.hbm.RootHB;
import org.srh.nettiapp.hbm.dao.BranchTimingsDao;
import org.srh.nettiapp.hbm.dto.BranchTimings;
import org.srh.nettiapp.hbm.hql.BranchTimingsQuery;
import org.srh.util.StringUtil;
/**
 * Implementation class of HBM DAO {@link BranchMasterDao}
 * Date: 05 Dec 2018
 * @author Yashas
 */

	
	public class BranchTimingsDaoImpl implements BranchTimingsDao {

		@Override
		public BranchTimings findbybranchId(int branchId) {
			BranchTimings branchTimings = null;
			Session session = RootHB.getSessionFactory().openSession();
			try {
				branchTimings = session.find(BranchTimings.class, branchId);
			}
			catch(NoResultException ex) {
				System.err.println( StringUtil.append("No Branch exist with Id:", branchId) );
			}
			finally {
				RootHB.closeSession(session);
			}
			return branchId;
		}	
		
		public BranchTimings findBydDayInWeek(int dayInWeek) {
			BranchTimings branchTimings = null;
			Session session = RootHB.getSessionFactory().openSession();
			try {
				branchTimings = session.find(BranchTimings.class, dayInWeek);
			}
			catch(NoResultException ex) {
				System.err.println( StringUtil.append("No Branch exist with Id:", dayInWeek) );
			}
			finally {
				RootHB.closeSession(session);
			}
			return dayInWeek;
		}	
}
 