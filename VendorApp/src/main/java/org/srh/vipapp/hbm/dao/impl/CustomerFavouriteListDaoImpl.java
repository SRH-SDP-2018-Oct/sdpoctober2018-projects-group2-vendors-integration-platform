package org.srh.vipapp.hbm.dao.impl;

import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.srh.util.AppLog;
import org.srh.util.StringUtil;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.CustomerFavouriteListDao;
import org.srh.vipapp.hbm.dto.CustomerFavouriteList;

public class CustomerFavouriteListDaoImpl implements CustomerFavouriteListDao{

	@Override
	public CustomerFavouriteList findById(long id) {
		CustomerFavouriteList favouriteList = null;
		Session session = RootHB.getSessionFactory().openSession();
		try {
			favouriteList = session.find(CustomerFavouriteList.class, id);
		}
		catch(NoResultException ex) {
			AppLog.log(this.getClass(), StringUtil.append("No user exist with favourite list Id:", id) );
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
			favouriteList = session.find(CustomerFavouriteList.class, customerId);
		}
		catch(NoResultException ex) {
			AppLog.log(this.getClass(), StringUtil.append("No favourite list exists with this Customer Id:", customerId) );
		}
		finally {
			RootHB.closeSession(session);
		}
		return favouriteList;
	}

}
