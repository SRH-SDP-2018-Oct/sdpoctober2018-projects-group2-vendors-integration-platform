package org.srh.vipapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
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
import org.srh.vipapp.activity.CartActivity;
import org.srh.vipapp.hbm.dao.CustomerCartDao;
import org.srh.vipapp.hbm.dao.impl.CustomerCartDaoImpl;
import org.srh.vipapp.hbm.dto.CustomerCart;
import org.srh.vipapp.service.CustomerCartService;


/**
 * Service Implementation of {@link CustomerCartService}.  <br/>
 * Date: 09 Dec 2018
 * @author Anglita
 */
@Service
public class CustomerCartServiceImpl implements CustomerCartService {

	private CustomerCartDao customerCartDao = new CustomerCartDaoImpl();
	private CartActivity cartActivity = new CartActivity();


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
			JSONObject jsonData = new JSONObject(data).getJSONObject(KeyPairConstants.CART_DATA);
			productId = Long.valueOf(jsonData.getString(KeyPairConstants.CART_PRODUCT_ID));
			productCount = Integer.valueOf(jsonData.getString(KeyPairConstants.CART_PRODUCT_COUNT));
			if(jsonData.has(KeyPairConstants.CART_DISPLAY_NAME)) {
				displayName = jsonData.getString(KeyPairConstants.CART_DISPLAY_NAME);
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

		// Logic to save cart
		return cartActivity.saveCart(cId, displayName, productId, productCount);
	}


	@Override
	public ServiceResp addAllProduct(String data, String customerId) {
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
		List<Long> productIdList;
		List<Integer> productCountList;
		String displayName;
		JSONArray jsonDataArray;
		try {
			JSONObject jsonData = new JSONObject(data).getJSONObject(KeyPairConstants.CART_DATA);
			if(jsonData.has(KeyPairConstants.CART_DISPLAY_NAME)) {
				displayName = jsonData.getString(KeyPairConstants.CART_DISPLAY_NAME);
			}
			else {
				displayName = DateUtil.getMMDDYYYY_HHMMSS();
			}
			jsonDataArray = jsonData.getJSONArray(KeyPairConstants.CART_PRODUCT_DATA);
			int len = jsonData.length();
			productIdList = new ArrayList<>(len);
			productCountList = new ArrayList<>(len);
			for(int i=0; i<len; i++) {
				JSONObject jsonObject = jsonDataArray.getJSONObject(i);
				productIdList.add(Long.valueOf(jsonObject.getString(KeyPairConstants.CART_PRODUCT_ID)));
				productCountList.add(Integer.valueOf(jsonObject.getString(KeyPairConstants.CART_PRODUCT_COUNT)));
			}
		}
		catch(Exception ex) {
			String description = StringUtil.append("Invalid data format [", data, "] provided as an input.");
			AppLog.log(CustomerCartServiceImpl.class, description, ex);
			return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
		}

		// Logic to save cart
		return cartActivity.saveCart(cId, displayName, productIdList, productCountList);
	}

}


