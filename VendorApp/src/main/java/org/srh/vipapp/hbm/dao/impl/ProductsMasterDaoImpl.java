package org.srh.vipapp.hbm.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.srh.util.AppLog;
import org.srh.util.StringUtil;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.ProductsMasterDao;
import org.srh.vipapp.hbm.dto.CartProduct;
import org.srh.vipapp.hbm.dto.CustomerMaster;
import org.srh.vipapp.hbm.dto.ProductsMaster;
import org.srh.vipapp.hbm.hql.ProductsMasterQuery;

/** 
 * Implementation class of HBM DAO {@link ProductsMasterDao}
 * Date: 03 Dec 2018
 * @author Anglita
 */
public class ProductsMasterDaoImpl implements ProductsMasterDao {

	@Override
	public ProductsMaster findById(long productId) {
		ProductsMaster productMaster = null;
		Session session = RootHB.getSessionFactory().openSession();
		try {
			productMaster = session.find(ProductsMaster.class, productId);
		}
		catch(NoResultException ex) {
			AppLog.log(this.getClass(), StringUtil.append("No user exist with product Id:", productId) );
		}
		finally {
			RootHB.closeSession(session);
		}
		return productMaster;
	}

	@Override
	public ProductsMaster findById(long productId, Session session) {
		ProductsMaster productMaster = null;
		try {
			productMaster = session.find(ProductsMaster.class, productId);
		}
		catch(NoResultException ex) {
			AppLog.log(this.getClass(), StringUtil.append("No user exist with product Id:", productId) );
		}
		return productMaster;
	}


	@Override
	public List<ProductsMaster> getAllProducts() {
		List<ProductsMaster> productsList = null;
		try ( Session session = RootHB.getSessionFactory().openSession(); ) 
		{
			@SuppressWarnings("unchecked")
			Query<ProductsMaster> query = session.createNamedQuery(ProductsMasterQuery.GET_ALL_PRODUCTS_$N);
			productsList = query.getResultList();
			return productsList;
		}
		catch(NoResultException ex)
		{
			AppLog.log(this.getClass(), StringUtil.append("There are no products!",ex.getMessage()) );
			return productsList;
		}

	}

	@Override
	public List<ProductsMaster> findbyProductName(String productName) {
		Session session = RootHB.getSessionFactory().openSession();
		try {
			@SuppressWarnings("unchecked")
			Query<ProductsMaster> query = session.createNamedQuery(ProductsMasterQuery.FIND_PRODUCT_BY_PRODUCTNAME_$N);
			query.setParameter(ProductsMasterQuery.FIND_PRODUCT_BY_PRODUCTNAME_$P1, StringUtil.append(productName,"%"));
			return query.getResultList();
		}
		catch(NoResultException ex) {
			AppLog.log(this.getClass(), StringUtil.append("There are no products on Offers", ex.getMessage()) );
			return new ArrayList<>();
		}
		finally {
			RootHB.closeSession(session);
		}

	}

	@Override
	public List<ProductsMaster> getProductsByProductType(String productTypeName) {
		Session session = RootHB.getSessionFactory().openSession();
		try {
			/*
			@SuppressWarnings("unchecked")
			Query<ProductsMaster> query = session.createNamedQuery(ProductsMasterQuery.FIND_PRODUCT_BY_PRODUCTTYPE_$N);
			query.setParameter(ProductsMasterQuery.FIND_PRODUCT_BY_PRODUCTTYPE_$P1, StringUtil.append(productTypeName,"%"));
			return query.getResultList();
			*/
			return new ArrayList<>();
		}
		catch(NoResultException ex) {
			AppLog.log(this.getClass(), StringUtil.append("There are no products of the productType", ex.getMessage()) );
			return new ArrayList<>();
		}
		finally {
			RootHB.closeSession(session);
		}

	}


	@Override
	public List<ProductsMaster> getAllProductsOnOffer() {
		Session session = RootHB.getSessionFactory().openSession();
		try {
			@SuppressWarnings("unchecked")
			Query<ProductsMaster> query = session.createNamedQuery(ProductsMasterQuery.FIND_PRODUCT_BY_OFFERS_$N);
			return query.getResultList();

		}
		catch(NoResultException ex){
			AppLog.log(this.getClass(), StringUtil.append("There are no products on Offers!",ex.getMessage()) );
		}
		finally {
			RootHB.closeSession(session);
		}
		return new ArrayList<>();
	}


	@Override
	public List<ProductsMaster> frequentlyBoughtByCustomer(CustomerMaster customerMaster) {
		List<ProductsMaster> listProduct = new ArrayList<>();
		Session session = RootHB.getSessionFactory().openSession();
		try {
			@SuppressWarnings("unchecked")
			NativeQuery<CartProduct> nativeQuery = session.createSQLQuery(ProductsMasterQuery.GET_FREQUENT_PRODUCDTS_Q);
			Query<CartProduct> query = nativeQuery.addEntity("cp", CartProduct.class);
			query.setParameter(ProductsMasterQuery.GET_FREQUENT_PRODUCDTS_P1, customerMaster);
			List<CartProduct> listCartProduct = query.getResultList();
			if(listCartProduct.isEmpty())
				return listProduct;
			int size = listCartProduct.size();
			for(int i=0; i<size; i++) {
				CartProduct cartProduct = listCartProduct.get(i);
				listProduct.add(cartProduct.getProductId());
			}
		}
		catch(NoResultException ex){
			AppLog.log(this.getClass(), StringUtil.append("There are no products on Offers!",ex.getMessage()) );
		}
		finally {
			RootHB.closeSession(session);
		}
		return listProduct;
	}
	

}
