package org.srh.vipapp.activity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.srh.bean.ServiceResp;
import org.srh.constants.ErrorCode;
import org.srh.util.Common;
import org.srh.util.StringUtil;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.CustomerMasterDao;
import org.srh.vipapp.hbm.dao.ProductsMasterDao;
import org.srh.vipapp.hbm.dao.impl.CustomerMasterDaoImpl;
import org.srh.vipapp.hbm.dao.impl.ProductsMasterDaoImpl;
import org.srh.vipapp.hbm.dto.CustomerFavouriteList;
import org.srh.vipapp.hbm.dto.CustomerMaster;
import org.srh.vipapp.hbm.dto.FavouriteListProduct;
import org.srh.vipapp.hbm.dto.ProductsMaster;
import org.srh.vipapp.hbm.dto.UserMaster;

/**
 * Date: 10 Dec 2018 
 * @author Anglita
 */
public class FavouriteListActivity {

	private CustomerMasterDao customerMasterDao = new CustomerMasterDaoImpl();
	private ProductsMasterDao productsMasterDao = new ProductsMasterDaoImpl();

	public ServiceResp saveFavouriteList(Long customerId, Long productId) {
		Session session = RootHB.getSessionFactory().openSession();

		// Cart Transaction
		Transaction transaction = session.beginTransaction();
		try {
			// 
			CustomerMaster customerMaster = customerMasterDao.findById(customerId, session);
			if(customerMaster==null) {
				RootHB.closeSession(session);
				String description = StringUtil.append("The customer id [", customerId, "] is invalid integer.");
				return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
			}

			// 
			UserMaster systemUser = RootHB.getSystemUser();

			// Create [CustomerFavouriteList] entity object to save it.
			CustomerFavouriteList favouriteList = new CustomerFavouriteList();
			favouriteList.setCustomerId(customerMaster);
			favouriteList.setCreatedBy(systemUser);
			favouriteList.setModifiedBy(systemUser);
			
			session.save(favouriteList);

			// Save Products in CustomerFavouriteList
			ProductsMaster productsMaster = productsMasterDao.findById(productId, session);
			if(productsMaster==null) {
				String description = StringUtil.append("The product id [", productId, "] is invalid integer.");
				return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
			}
			saveFavouriteProduct(session,favouriteList, productsMaster, systemUser);

			transaction.commit();
			return Common.buildServiceResp(favouriteList);
		}
		catch(Exception ex) {
			transaction.rollback();
			String desc = ex.getMessage();
			return Common.buildServiceRespError(ErrorCode.EXCEPTION, desc);
		}
		finally {
			RootHB.closeSession(session);
		}
	}


	public ServiceResp saveFavouriteList(Long customerId, List<Long> productList) {
		Session session = RootHB.getSessionFactory().openSession();

		// Cart Transaction
		Transaction transaction = session.beginTransaction();
		try {
			// 
			CustomerMaster customerMaster = customerMasterDao.findById(customerId, session);
			if(customerMaster==null) {
				RootHB.closeSession(session);
				String description = StringUtil.append("The customer id [", customerId, "] is invalid integer.");
				return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
			}

			// 
			UserMaster systemUser = RootHB.getSystemUser();

			// Create [CustomerFavouriteList] entity object to save it.
			CustomerFavouriteList favouriteList = new CustomerFavouriteList();
			favouriteList.setCustomerId(customerMaster);
			favouriteList.setCreatedBy(systemUser);
			favouriteList.setModifiedBy(systemUser);
			
			session.save(favouriteList);

			int len = productList.size();
			for(int i=0; i<len; i++) {
				// Save Products in Cart
				Long productId = productList.get(i);
				ProductsMaster productsMaster = productsMasterDao.findById(productId, session);
				if(productsMaster==null) {
					transaction.rollback();
					String description = StringUtil.append("The product id [", productId, "] is invalid integer.");
					return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
				}
				saveFavouriteProduct(session,favouriteList, productsMaster, systemUser);
			}

			transaction.commit();
			return Common.buildServiceResp(favouriteList);
		}
		catch(Exception ex) {
			transaction.rollback();
			String desc = ex.getMessage();
			return Common.buildServiceRespError(ErrorCode.EXCEPTION, desc);
		}
		finally {
			RootHB.closeSession(session);
		}
	}


	private FavouriteListProduct saveFavouriteProduct(Session session, CustomerFavouriteList favouriteList,
			ProductsMaster productsMaster, UserMaster systemUser) {
		FavouriteListProduct favouriteProduct = new FavouriteListProduct();
		favouriteProduct.setListId(favouriteList);
		favouriteProduct.setProductId(productsMaster);
		favouriteProduct.setCreatedBy(systemUser);
		favouriteProduct.setModifiedBy(systemUser);
		session.save(favouriteProduct);
		return favouriteProduct;
	}


}
