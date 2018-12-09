package org.srh.vipapp.service.impl;

import java.util.List;

import org.srh.bean.ServiceResp;
import org.srh.bean.ServiceRespArray;
import org.srh.constants.ErrorCode;
import org.srh.util.Common;
import org.srh.util.NumberUtil;
import org.srh.util.StringUtil;
import org.srh.vipapp.hbm.dao.CustomerCartDao;
import org.srh.vipapp.hbm.dao.impl.CustomerCartDaoImpl;
import org.srh.vipapp.hbm.dto.CustomerCart;
import org.srh.vipapp.service.CustomerCartService;


/**
 * Service Implementation of {@link CustomerCartService}.  <br/>
 * Date: 09 Dec 2018
 * @author Anglita
 */
public class CustomerCartServiceImpl implements CustomerCartService {

	private CustomerCartDao customerCartDao = new CustomerCartDaoImpl();

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
	public ServiceRespArray getCartsByUserId(String userId) {
		// Input Validation
		Integer uId = NumberUtil.getInteger(userId);
		if(uId==null) 
		{
			String description = StringUtil.append("The cart id [", uId, "] is invalid integer.");
			return Common.buildServiceRespArrayError(ErrorCode.INVALID_INPUT, description);
		}

		List<CustomerCart> customerCart = customerCartDao.findCartbyUserId(uId.intValue());

		// Validate Data Existence
		if(customerCart==null) 
		{
			String description =  StringUtil.append("No customer found with id [", uId, "].");
			return Common.buildServiceRespArrayError(ErrorCode.NOT_FOUND, description);
		}
		// Data Exist, Return Success
		return Common.buildServiceRespArray(customerCart);
	}

}


