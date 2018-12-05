/**
 * 
 */
package org.srh.vipapp.hbm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.ApiStructureConstantsDao;
import org.srh.vipapp.hbm.dto.ApiStructureConstants;
import org.srh.vipapp.hbm.hql.ApiStructureConstantsQuery;

/**
 * @author Maitreyee
 *
 */
public class ApiStructureConstantsDaoImpl implements ApiStructureConstantsDao {
	
	@Override
	public List<ApiStructureConstants> getAllVendorsApi() {
		try ( Session session = RootHB.getSessionFactory().openSession(); ) {
			@SuppressWarnings("unchecked")
			Query<ApiStructureConstants> query = session.createNamedQuery(ApiStructureConstantsQuery.GET_ALL_VENDOR_API_$N);
			List<ApiStructureConstants> apiStructureConstantsList = query.getResultList();
			return apiStructureConstantsList;
		}
	}

}
