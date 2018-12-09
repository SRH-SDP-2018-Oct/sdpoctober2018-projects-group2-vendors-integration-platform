package org.srh.vipapp.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.srh.bean.ServiceResp;
import org.srh.bean.ServiceRespArray;
import org.srh.constants.ErrorCode;
import org.srh.constants.KeyPairConstants;
import org.srh.util.AppLog;
import org.srh.util.Common;
import org.srh.util.DateUtil;
import org.srh.util.NumberUtil;
import org.srh.util.StringUtil;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.CustomerCartDao;
import org.srh.vipapp.hbm.dao.CustomerMasterDao;
import org.srh.vipapp.hbm.dao.ProductsMasterDao;
import org.srh.vipapp.hbm.dao.UserMasterDao;
import org.srh.vipapp.hbm.dao.impl.CustomerCartDaoImpl;
import org.srh.vipapp.hbm.dao.impl.CustomerMasterDaoImpl;
import org.srh.vipapp.hbm.dao.impl.ProductsMasterDaoImpl;
import org.srh.vipapp.hbm.dao.impl.UserMasterDaoImpl;
import org.srh.vipapp.hbm.dto.CustomerCart;
import org.srh.vipapp.hbm.dto.CustomerMaster;
import org.srh.vipapp.hbm.dto.ProductsMaster;
import org.srh.vipapp.hbm.dto.UserMaster;
import org.srh.vipapp.service.CustomerCartService;


/**
 * Service Implementation of {@link CustomerCartService}.  <br/>
 * Date: 09 Dec 2018
 * @author Anglita
 */
@Service
public class CustomerCartServiceImpl implements CustomerCartService {

	private UserMasterDao userMasterDao = new UserMasterDaoImpl();
	private CustomerCartDao customerCartDao = new CustomerCartDaoImpl();
	private CustomerMasterDao customerMasterDao = new CustomerMasterDaoImpl();
	private ProductsMasterDao productsMasterDao = new ProductsMasterDaoImpl();

	@Override
	public ServiceRespArray getAllCarts() {
		List<CustomerCart> allCartsList = customerCartDao.getAllCarts();

		// Validate Data Existence
		if(allCartsList==null || allCartsList.isEmpty()) {
			String description =  "No Products found.";
			return Common.buildServiceRespArrayError(ErrorCode.NOT_FOUND, description);
		}

		return Common.buildServiceRespArray(allCartsList);
	}

	@Override
	public ServiceResp getCartsByCartId(String cartId) {
		// Input Validation
		Long crtId = NumberUtil.getLong(cartId);
		if(crtId==null) {
			String description = StringUtil.append("The cart id [", cartId, "] is invalid integer.");
			return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
		}

		CustomerCart customerCart = customerCartDao.findByCartId(crtId.longValue());

		// Validate Data Existence
		if(customerCart==null) {
			String description =  StringUtil.append("No customer found with id [", crtId, "].");
			return Common.buildServiceRespError(ErrorCode.NOT_FOUND, description);
		}

		// Data Exist, Return Success
		return Common.buildServiceResp(customerCart);
	}

	@Override
	public ServiceRespArray getCartsByUserId(String customerId) {
		// Input Validation
		Long cId = NumberUtil.getLong(customerId);
		if(cId==null){
			String description = StringUtil.append("The customer id [", cId, "] is invalid integer.");
			return Common.buildServiceRespArrayError(ErrorCode.INVALID_INPUT, description);
		}

		List<CustomerCart> customerCart = customerCartDao.getCartByCustomerId(cId.longValue());

		// Validate Data Existence
		if(customerCart==null) {
			String description =  StringUtil.append("No card found with id [", cId, "].");
			return Common.buildServiceRespArrayError(ErrorCode.NOT_FOUND, description);
		}
		// Data Exist, Return Success
		return Common.buildServiceRespArray(customerCart);
	}


	@Override
	public ServiceResp addProduct(String data, String customerId) {
		if(Common.nullOrEmpty(data)) {
			String description = StringUtil.append("Invalid data [", data, "] provided as an input.");
			return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
		}
		Long cId = NumberUtil.getLong(customerId);
		if(cId==null){
			String description = StringUtil.append("The customer id [", cId, "] is invalid integer.");
			return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
		}

		// Fetch data from the request
		Long productId;
		Integer productCount;
		String displayName;
		try {
			JSONObject jsonData = new JSONObject(data).getJSONObject("data");
			productId = Long.valueOf(jsonData.getString(KeyPairConstants.CART_PRODUCT_ID));
			productCount = Integer.valueOf(jsonData.getString(KeyPairConstants.CART_PRODUCT_COUNT));
			if(jsonData.has(KeyPairConstants.CART_DISPLAY_NAME)) {
				displayName = KeyPairConstants.CART_DISPLAY_NAME;
			}
			else {
				displayName = DateUtil.getMMDDYYYY_HHMMSS();
			}
		}
		catch(Exception ex) {
			String description = StringUtil.append("Invalid data format [", data, "] provided as an input.");
			AppLog.log(CustomerCartServiceImpl.class, description, ex);
			return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
		}


		// Create session object
		Session session = RootHB.getSessionFactory().openSession();

		// 
		ProductsMaster productMaster = productsMasterDao.findById(productId, session);
		if(productMaster==null) {
			RootHB.closeSession(session);
			String description = StringUtil.append("The product id [", productId, "] is invalid integer.");
			return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
		}
		//
		CustomerMaster customerMaster = customerMasterDao.findById(cId, session);
		if(customerMaster==null) {
			RootHB.closeSession(session);
			String description = StringUtil.append("The customer id [", cId, "] is invalid integer.");
			return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
		}
		// 
		UserMaster systemUser = userMasterDao.findSystemUser(session);
		if(systemUser==null) {
			RootHB.closeSession(session);
			return Common.buildServiceRespError(ErrorCode.EXCEPTION, "System Error");
		}

		Transaction transaction = session.beginTransaction();
		try {
			// Create [CustomerCart] entity object to save it.
			CustomerCart customerCart = new CustomerCart();
			customerCart.setProductId(productMaster);
			customerCart.setProductCount(productCount);
			customerCart.setCustomerId(customerMaster);
			customerCart.setCreatedBy(systemUser);
			customerCart.setModifiedBy(systemUser);
			customerCart.setDisplayName(displayName);
			session.save(customerCart);
			transaction.commit();
			return Common.buildServiceResp(customerCart);
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


	@Override
	public ServiceResp addAllProduct(String data, String customerId) {
		return null;
	}

}


