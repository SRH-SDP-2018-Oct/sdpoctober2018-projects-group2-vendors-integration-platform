package org.srh.vipapp.hbm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.ApiStructureConstantsDao;
import org.srh.vipapp.hbm.dto.ApiStructureConstants;
import org.srh.vipapp.hbm.hql.ApiStructureConstantsQuery;

/**
 * Implementation class of HBM DAO {@link ApiStructureConstantsDao}
 * Date: 05 Nov 2018
 * @author Maitreyee
 */
public class ApiStructureConstantsDaoImpl implements ApiStructureConstantsDao {

	private List<ApiStructureConstants> listApiStructureConstants; 

	@Override
	public List<ApiStructureConstants> getAllApiStructConstants() {
		if(listApiStructureConstants==null) {
			try ( Session session = RootHB.getSessionFactory().openSession(); ) {
				@SuppressWarnings("unchecked")
				Query<ApiStructureConstants> query = session.createNamedQuery(ApiStructureConstantsQuery.GET_ALL_STRUCTURE_API_$N);
				listApiStructureConstants = query.getResultList();
			}
		}
		return listApiStructureConstants;
	}

}
