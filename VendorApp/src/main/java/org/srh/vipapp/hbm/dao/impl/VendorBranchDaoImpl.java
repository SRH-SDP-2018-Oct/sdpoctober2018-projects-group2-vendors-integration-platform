package org.srh.vipapp.hbm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.srh.util.AppLog;
import org.srh.util.StringUtil;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.VendorBranchDao;
import org.srh.vipapp.hbm.dao.VendorMasterDao;
import org.srh.vipapp.hbm.dto.VendorBranch;
import org.srh.vipapp.hbm.dto.VendorMaster;
import org.srh.vipapp.hbm.hql.VendorBranchQuery;

public class VendorBranchDaoImpl implements VendorBranchDao {

	private VendorMasterDao vendorMasterDao = new VendorMasterDaoImpl();


	@Override
	public List<VendorBranch> getAllBranches(int vendorId) {
		try ( Session session = RootHB.getSessionFactory().openSession(); ) {
			VendorMaster vendorMaster = vendorMasterDao.findById(vendorId, session);
			if(vendorMaster==null) {
				AppLog.log(ApiStructureDaoImpl.class, StringUtil.append("Vendor with id '", vendorId, "' not found"));
				return new ArrayList<>();
			}
			@SuppressWarnings("unchecked")
			Query<VendorBranch> query = session.createNamedQuery(VendorBranchQuery.GET_ALL_VENDOR_BRANCHES_$N);
			query.setParameter(VendorBranchQuery.GET_ALL_VENDOR_BRANCHES_$P1, vendorMaster);
			return query.getResultList();
		}
	}


	@Override
	public List<VendorBranch> getAllBranches(String vendorName) {
		try ( Session session = RootHB.getSessionFactory().openSession(); ) {
			VendorMaster vendorMaster = vendorMasterDao.findByVendorName(vendorName,session);
			if(vendorMaster==null) {
				AppLog.log(ApiStructureDaoImpl.class, StringUtil.append("Vendor with name '", vendorName, "' not found"));
				return new ArrayList<>();
			}
			@SuppressWarnings("unchecked")
			Query<VendorBranch> query = session.createNamedQuery(VendorBranchQuery.GET_ALL_VENDOR_BRANCHES_$N);
			query.setParameter(VendorBranchQuery.GET_ALL_VENDOR_BRANCHES_$P1, vendorMaster);
			return query.getResultList();
		}
	}

}
