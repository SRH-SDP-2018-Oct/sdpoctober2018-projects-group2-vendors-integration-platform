package org.srh.aldoapp.hbm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.srh.aldoapp.hbm.RootHB;
import org.srh.aldoapp.hbm.dao.ProductMasterDao;
import org.srh.aldoapp.hbm.dto.ProductMaster;
import org.srh.aldoapp.hbm.hql.ProductMasterQuery;

public class ProductMasterDaoImpl implements ProductMasterDao {

	@Override
	public List<ProductMaster> getAllProducts() {
		try ( Session session = RootHB.getSessionFactory().openSession(); ) {
			@SuppressWarnings("unchecked")
			Query<ProductMaster> query = session.createNamedQuery(ProductMasterQuery.GET_ALL_PRODUCTS_$N);
			return query.getResultList();
		}
	}

}
