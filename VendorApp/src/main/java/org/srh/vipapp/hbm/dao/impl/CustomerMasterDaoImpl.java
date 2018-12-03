package org.srh.vipapp.hbm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.srh.util.StringUtil;
import org.srh.util.AppLog;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.CustomerMasterDao;
import org.srh.vipapp.hbm.dto.CustomerMaster;
import org.srh.vipapp.hbm.hql.CustomerMasterQuery;

/**
 * Implementation class of HBM DAO {@link CustomerMasterDao}
 * Date: 01 Dec 2018
 * @author Vivek
 */
public class CustomerMasterDaoImpl implements CustomerMasterDao {


	@Override
	public CustomerMaster findById(long customerId) {
		CustomerMaster customerMaster = null;
		Session session = RootHB.getSessionFactory().openSession();
		try {
			customerMaster = session.find(CustomerMaster.class, customerId);
		}
		catch(NoResultException ex) {
			AppLog.log(this.getClass(), StringUtil.append("No customer exist with Id:", customerId) );
		}
		finally {
			RootHB.closeSession(session);
		}
		return customerMaster;
	}


	@Override
	public List<CustomerMaster> getAllCustomers() {
		try ( Session session = RootHB.getSessionFactory().openSession(); ) {
			@SuppressWarnings("unchecked")
			Query<CustomerMaster> query = session.createNamedQuery(CustomerMasterQuery.GET_ALL_CUSTOMERS_$N);
			return query.getResultList();
		}
	}


	@Override
	public CustomerMaster findByUsername(String customerUsername) {
		Session session = RootHB.getSessionFactory().openSession();
		try {
			@SuppressWarnings("unchecked")
			Query<CustomerMaster> query = session.createNamedQuery(CustomerMasterQuery.FIND_CUSTOMER_BY_USERNAME_$N);
			query.setParameter(CustomerMasterQuery.FIND_CUSTOMER_BY_USERNAME_$P1, customerUsername);
			return query.getSingleResult();
		}
		catch(NoResultException ex) {
			AppLog.log(this.getClass(), StringUtil.append("No Customer exist with Username:", customerUsername) );
			return null;
		}
		finally {
			RootHB.closeSession(session);
		}
	}


	@Override
	public List<CustomerMaster> findByName(String name) {
		Session session = RootHB.getSessionFactory().openSession();
		try {
			@SuppressWarnings("unchecked")
			Query<CustomerMaster> query = session.createNamedQuery(CustomerMasterQuery.FIND_CUSTOMERS_BY_NAME_$N);
			query.setParameter(CustomerMasterQuery.FIND_CUSTOMERS_BY_NAME_$P1, StringUtil.append(name,"%"));
			query.setParameter(CustomerMasterQuery.FIND_CUSTOMERS_BY_NAME_$P2, StringUtil.append(name,"%"));
			return query.getResultList();
		}
		catch(NoResultException ex) {
			AppLog.log(this.getClass(), StringUtil.append("No Customer exist with first name or last name:", name) );
			return new ArrayList<>();
		}
		finally {
			RootHB.closeSession(session);
		}
	}

}
