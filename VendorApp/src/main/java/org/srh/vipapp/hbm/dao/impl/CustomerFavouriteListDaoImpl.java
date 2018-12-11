package org.srh.vipapp.hbm.dao.impl;

import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.srh.util.AppLog;
import org.srh.util.StringUtil;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.CustomerFavouriteListDao;
import org.srh.vipapp.hbm.dao.CustomerMasterDao;
import org.srh.vipapp.hbm.dto.CustomerFavouriteList;
import org.srh.vipapp.hbm.dto.CustomerMaster;
import org.srh.vipapp.hbm.hql.CustomerFavouriteListQuery;

public class CustomerFavouriteListDaoImpl implements CustomerFavouriteListDao{

	private CustomerMasterDao customerMasterDao = new CustomerMasterDaoImpl();


	@Override
	public CustomerFavouriteList findById(long id) {
		CustomerFavouriteList favouriteList = null;
		Session session = RootHB.getSessionFactory().openSession();
		try {
			favouriteList = session.find(CustomerFavouriteList.class, id);
		}
		catch(NoResultException ex) {
			AppLog.log(this.getClass(), StringUtil.append("No entry found with favourite list Id:", id) );
		}
		finally {
			RootHB.closeSession(session);
		}
		return favouriteList;
	}


	@Override
	public CustomerFavouriteList findByCustomerId(long customerId) {
		CustomerFavouriteList favouriteList = null;
		Session session = RootHB.getSessionFactory().openSession();
		try {
			CustomerMaster customerMaster = customerMasterDao.findById(customerId, session);
			@SuppressWarnings("unchecked")
			Query<CustomerFavouriteList> query = session.createNamedQuery(CustomerFavouriteListQuery.GET_FAVOURITE_CART_BY_CUSTOMERID_$N);
			query.setParameter(CustomerFavouriteListQuery.GET_FAVOURITE_CART_BY_CUSTOMERID_$P1, customerMaster);
			favouriteList = query.getSingleResult();
		}
		catch(NoResultException ex) {
			AppLog.log(this.getClass(), StringUtil.append("No favourite list exists for the Customer Id: ", customerId) );
		}
		finally {
			RootHB.closeSession(session);
		}
		return favouriteList;
	}

}
