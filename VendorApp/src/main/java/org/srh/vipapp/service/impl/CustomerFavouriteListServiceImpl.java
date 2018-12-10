package org.srh.vipapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.srh.bean.ServiceResp;
import org.srh.bean.ServiceRespArray;
import org.srh.constants.ErrorCode;
import org.srh.constants.KeyPairConstants;
import org.srh.util.AppLog;
import org.srh.util.Common;
import org.srh.util.NumberUtil;
import org.srh.util.StringUtil;
import org.srh.vipapp.activity.FavouriteListActivity;
import org.srh.vipapp.hbm.dao.CustomerFavouriteListDao;
import org.srh.vipapp.hbm.dao.impl.CustomerFavouriteListDaoImpl;
import org.srh.vipapp.hbm.dto.CustomerFavouriteList;
import org.srh.vipapp.service.CustomerFavouriteListService;

public class CustomerFavouriteListServiceImpl implements CustomerFavouriteListService {

	private CustomerFavouriteListDao customerFavouriteListDao = new CustomerFavouriteListDaoImpl();
	private FavouriteListActivity favouriteListActivity = new FavouriteListActivity();

	@Override
	public ServiceResp getFavouriteListById(String listId) {
		// Input Validation
		Long lstId = NumberUtil.getLong(listId);
		if(lstId==null) {
			String description = StringUtil.append("The favourite list id [", listId, "] is invalid integer.");
			return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
		}

		CustomerFavouriteList favouriteList = customerFavouriteListDao.findById(lstId);

		// Validate Data Existence
		if(favouriteList==null) {
			String description =  StringUtil.append("No customer found with id [", lstId, "].");
			return Common.buildServiceRespError(ErrorCode.NOT_FOUND, description);
		}

		// Data Exist, Return Success
		return Common.buildServiceResp(favouriteList);
	}

	@Override
	public ServiceResp getFavouriteListByCustomerId(String customerId) {
		// Input Validation
		Long cId = NumberUtil.getLong(customerId);
		if(cId==null){
			String description = StringUtil.append("The customer id [", cId, "] is invalid integer.");
			return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
		}

		CustomerFavouriteList favouriteList = customerFavouriteListDao.findByCustomerId(cId.longValue());

		// Validate Data Existence
		if(favouriteList==null) {
			String description =  StringUtil.append("No favourite list found with id [", cId, "].");
			return Common.buildServiceRespError(ErrorCode.NOT_FOUND, description);
		}
		// Data Exist, Return Success
		return Common.buildServiceResp(favouriteList);
	}

	@Override
	public ServiceResp addProductToFavouriteList(String data, String customerId) {
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

		try {
			JSONObject jsonData = new JSONObject(data).getJSONObject(KeyPairConstants.LIST_DATA);
			productId = Long.valueOf(jsonData.getString(KeyPairConstants.LIST_PRODUCT_ID));
		}
		catch(Exception ex) {
			String description = StringUtil.append("Invalid data format [", data, "] provided as an input.");
			AppLog.log(CustomerFavouriteListServiceImpl.class, description, ex);
			return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
		}

		// Logic to save favourite list
		return favouriteListActivity.saveFavouriteList(cId, productId);
	}

	@Override
	public ServiceRespArray addProductsToFavouriteList(String data, String customerId) {
		if(Common.nullOrEmpty(data)) {
			String description = StringUtil.append("Invalid data [", data, "] provided as an input.");
			return Common.buildServiceRespArrayError(ErrorCode.INVALID_INPUT, description);
		}
		Long cId = NumberUtil.getLong(customerId);
		if(cId==null){
			String description = StringUtil.append("The customer id [", cId, "] is invalid integer.");
			return Common.buildServiceRespArrayError(ErrorCode.INVALID_INPUT, description);
		}

		// Fetch data from the request
		List<Long> productId;
		JSONArray jsonDataArray;
		try {
			JSONObject jsonData = new JSONObject(data).getJSONObject(KeyPairConstants.LIST_DATA);
			jsonDataArray = jsonData.getJSONArray(KeyPairConstants.LIST_PRODUCT_DATA);
			int len = jsonData.length();
			productId = new ArrayList<>(len);
			for(int i=0; i<len; i++) {
				JSONObject jsonObject = jsonDataArray.getJSONObject(i);
				productId.add(Long.valueOf(jsonObject.getString(KeyPairConstants.LIST_PRODUCT_ID)));

			}
		}
		catch(Exception ex) {
			String description = StringUtil.append("Invalid data format [", data, "] provided as an input.");
			AppLog.log(CustomerFavouriteListServiceImpl.class, description, ex);
			return Common.buildServiceRespArrayError(ErrorCode.INVALID_INPUT, description);
		}

		// Logic to save favourite list
		return Common.buildServiceRespArray(jsonDataArray.toList());
		//return cartActivity.saveCart(productId, cId, productCount, displayName);
	}

}
