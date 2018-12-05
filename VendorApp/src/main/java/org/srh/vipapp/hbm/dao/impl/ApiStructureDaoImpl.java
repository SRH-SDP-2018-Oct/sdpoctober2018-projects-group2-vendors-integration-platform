/**
 * 
 */
package org.srh.vipapp.hbm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.ApiStructureDao;
import org.srh.vipapp.hbm.dto.ApiStructure;
import org.srh.vipapp.hbm.hql.ApiStructureQuery;

/**
 * Date: 05 Nov 2018
 * @author Maitreyee
 */
public class ApiStructureDaoImpl implements ApiStructureDao{
	
	@Override
	public List<ApiStructure> getAllVendorsApi() {
		try ( Session session = RootHB.getSessionFactory().openSession(); ) {
			@SuppressWarnings("unchecked")
			Query<ApiStructure> query = session.createNamedQuery(ApiStructureQuery.GET_ALL_VENDOR_API_$N);
			List<ApiStructure> apiStructureList = query.getResultList();
			return apiStructureList;
		}
	}

}
