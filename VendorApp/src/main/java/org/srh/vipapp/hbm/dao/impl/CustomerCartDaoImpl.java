package org.srh.vipapp.hbm.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.srh.util.AppLog;
import org.srh.util.StringUtil;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.CustomerCartDao;
import org.srh.vipapp.hbm.dao.CustomerMasterDao;
import org.srh.vipapp.hbm.dto.CustomerCart;
import org.srh.vipapp.hbm.dto.CustomerMaster;
import org.srh.vipapp.hbm.hql.CustomerCartQuery;


/**
 * Implementation class of HBM DAO {@link CustomerCartDao}
 * Date: 09 Dec 2018
 * @author Anglita
 */
public class CustomerCartDaoImpl implements CustomerCartDao {

	CustomerMasterDao customerMasterDao = new CustomerMasterDaoImpl();

	@Override
	public CustomerCart findByCartId(long cartId) {
		CustomerCart customerCart = null;
		Session session = RootHB.getSessionFactory().openSession();
		try {
			customerCart = session.find(CustomerCart.class, cartId);
		}
		catch(NoResultException ex) {
			AppLog.log(this.getClass(), StringUtil.append("No user exist with product Id:", customerCart) );
		}
		finally {
			RootHB.closeSession(session);
		}
		return customerCart;
	}

	@Override
	public List<CustomerCart> getAllCarts() {
		List<CustomerCart> cartsList = null;
		try ( Session session = RootHB.getSessionFactory().openSession(); ) 
		{
			@SuppressWarnings("unchecked")
			Query<CustomerCart> query = session.createNamedQuery(CustomerCartQuery.GET_ALL_CUSTOMER_CARTS_$N);
			cartsList = query.getResultList();
			return cartsList;
		}
		catch(NoResultException ex)
		{
			AppLog.log(this.getClass(), StringUtil.append("There are no carts!",ex.getMessage()) );
			return cartsList;
		}
	}

	@Override
	public List<CustomerCart> getCartByCustomerId(long customerId) {
		List<CustomerCart> cartsList = null;
		try ( Session session = RootHB.getSessionFactory().openSession(); ){
			CustomerMaster customerMaster = customerMasterDao.findById(customerId);
			@SuppressWarnings("unchecked")
			Query<CustomerCart> query = session.createNamedQuery(CustomerCartQuery.GET_CUSTOMER_CARTS_BY_CUSTOMERID_$N);
			query.setParameter(CustomerCartQuery.GET_CUSTOMER_CARTS_BY_CUSTOMERID_$P1, customerMaster);
			return query.getResultList();
		}
		catch(NoResultException ex)
		{
			AppLog.log(this.getClass(), StringUtil.append("There are no carts for this User!",ex.getMessage()) );
			return cartsList;
		}
	}

}
