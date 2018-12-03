/**
 * 
 */
package org.srh.vipapp.hbm.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.srh.util.StringUtil;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.VendorMasterDao;
import org.srh.vipapp.hbm.dto.VendorMaster;
import org.srh.vipapp.hbm.hql.VendorMasterQuery;

/**
 * Implementation class of HBM DAO {@link VendorMasterDao}
 * Date: 29 Nov 2018
 * @author Maitreyee
 */
public class VendorMasterDaoImpl implements VendorMasterDao {
	

	@Override
	public VendorMaster findById(int vendorId) {
		VendorMaster vendorMaster = null;
		Session session = RootHB.getSessionFactory().openSession();
		try {
			vendorMaster = session.find(VendorMaster.class, vendorId);
		}
		catch(NoResultException ex) {
			System.err.println( StringUtil.append("No Vendor exist with Id:", vendorId) );
		}
		finally {
			RootHB.closeSession(session);
		}
		return vendorMaster;
	}	
	

	@Override
	public List<VendorMaster> getAllVendor() {
		try ( Session session = RootHB.getSessionFactory().openSession(); ) {
			@SuppressWarnings("unchecked")
			Query<VendorMaster> query = session.createNamedQuery(VendorMasterQuery.GET_ALL_VENDOR_$N);
			List<VendorMaster> vendorMasterList = query.getResultList();
			return vendorMasterList;
		}
	}


	@Override
	public VendorMaster findByVendorname(String vendorname) {
		Session session = RootHB.getSessionFactory().openSession();
		try {
			@SuppressWarnings("unchecked")
			Query<VendorMaster> query = session.createNamedQuery(VendorMasterQuery.FIND_VENDOR_BY_VENDORNAME_$N);
			query.setParameter(VendorMasterQuery.FIND_VENDOR_BY_VENDORNAME_$P1, vendorname);
			return query.getSingleResult();
		}
		catch(NoResultException ex) {
			System.err.println( StringUtil.append("No user with exist with Username:", vendorname) );
			return null;
		}
		finally {
			RootHB.closeSession(session);
		}
	}


}
