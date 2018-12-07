/**
 * 
 */
package org.srh.vipapp.hbm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.ApiStructureDao;
import org.srh.vipapp.hbm.dao.VendorMasterDao;
import org.srh.vipapp.hbm.dto.ApiStructure;
import org.srh.vipapp.hbm.dto.VendorMaster;
import org.srh.vipapp.hbm.hql.ApiStructureQuery;

/**
 * Date: 05 Nov 2018
 * @author Maitreyee
 */
public class ApiStructureDaoImpl implements ApiStructureDao {

	VendorMasterDao vendorMasterDao = new VendorMasterDaoImpl();

	@Override
	public List<ApiStructure> getApiStructureOfVendor(int vendorId) {
		try ( Session session = RootHB.getSessionFactory().openSession(); ) {
			VendorMaster vendor = vendorMasterDao.findById(vendorId, session);
			@SuppressWarnings("unchecked")
			Query<ApiStructure> query = session.createNamedQuery(ApiStructureQuery.GET_API_STRUCTURE_OF_VENDOR_$N);
			query.setParameter(ApiStructureQuery.GET_API_STRUCTURE_OF_VENDOR_$P1, vendor);
			return query.getResultList();
		}
	}

	@Override
	public List<ApiStructure> getApiStructureOfVendor(String vendorName) {
		try ( Session session = RootHB.getSessionFactory().openSession(); ) {
			VendorMaster vendor = vendorMasterDao.findByVendorName(vendorName, session);
			@SuppressWarnings("unchecked")
			Query<ApiStructure> query = session.createNamedQuery(ApiStructureQuery.GET_API_STRUCTURE_OF_VENDOR_$N);
			query.setParameter(ApiStructureQuery.GET_API_STRUCTURE_OF_VENDOR_$P1, vendor);
			return query.getResultList();
		}
	}


}
