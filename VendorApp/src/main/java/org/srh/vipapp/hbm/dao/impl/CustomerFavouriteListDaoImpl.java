package org.srh.vipapp.hbm.dao.impl;

import java.util.ArrayList;
import java.util.List;

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
import org.srh.vipapp.hbm.dto.FavouriteListProduct;
import org.srh.vipapp.hbm.dto.ProductsMaster;
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
			query.setMaxResults(1);
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


	@Override
	public List<ProductsMaster> getFavouriteProducts(long customerId) {
		List<ProductsMaster> productList = new ArrayList<>();
		Session session = RootHB.getSessionFactory().openSession();
		try {
			CustomerMaster customerMaster = customerMasterDao.findById(customerId, session);
			@SuppressWarnings("unchecked")
			Query<CustomerFavouriteList> query = session.createNamedQuery(CustomerFavouriteListQuery.GET_FAVOURITE_CART_BY_CUSTOMERID_$N);
			query.setParameter(CustomerFavouriteListQuery.GET_FAVOURITE_CART_BY_CUSTOMERID_$P1, customerMaster);
			query.setMaxResults(1);
			CustomerFavouriteList favouriteList = query.getSingleResult();

			@SuppressWarnings("unchecked")
			Query<FavouriteListProduct> queryFp = session.createNamedQuery(CustomerFavouriteListQuery.GET_FAVOURITE_CART_PRODUCTS_$N);
			queryFp.setParameter(CustomerFavouriteListQuery.GET_FAVOURITE_CART_PRODUCTS_$P1, favouriteList);
			List<FavouriteListProduct> favouriteProducts = queryFp.getResultList();
			
			if(favouriteProducts==null)
				return productList;

			int size = favouriteProducts.size();
			if(size==0)
				return productList;
	
			for(int i=0; i<size; i++) {
				FavouriteListProduct fp = favouriteProducts.get(i);
				productList.add(fp.getProductId());
			}
		}
		catch(NoResultException ex) {
			AppLog.log(this.getClass(), StringUtil.append("No favourite list exists for the Customer Id: ", customerId) );
		}
		finally {
			RootHB.closeSession(session);
		}
		return productList;
	}

}
