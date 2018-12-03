package org.srh.vipapp.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;
import org.srh.bean.ServiceResp;
import org.srh.bean.ServiceRespArray;
import org.srh.constants.ErrorCode;
import org.srh.util.AppLog;
import org.srh.util.Common;
import org.srh.util.NumberUtil;
import org.srh.util.StringUtil;
import org.srh.vipapp.hbm.dao.CustomerMasterDao;
import org.srh.vipapp.hbm.dao.impl.CustomerMasterDaoImpl;
import org.srh.vipapp.hbm.dto.CustomerMaster;
import org.srh.vipapp.service.CustomerService;

/**
 * Serivce Implementation of {@link CustomerService}.  <br/>
 * Date: 01 Dec 2018
 * @author Vivek
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerMasterDao customerMasterDao = new CustomerMasterDaoImpl();


	@Override
	public ServiceResp getCustomerById(String customerId) {
		// Input Validation
		Long cId = NumberUtil.getLong(customerId);
		if(cId==null) {
			String description = StringUtil.append("The customer id [", customerId, "] is invalid integer.");
			return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
		}

		CustomerMaster customerMaster = customerMasterDao.findById(cId.longValue());

		// Validate Data Existence
		if(customerMaster==null) {
			String description =  StringUtil.append("No customer found with id [", customerId, "].");
			return Common.buildServiceRespError(ErrorCode.NOT_FOUND, description);
		}

		// Data Exist, Return Success
		return Common.buildServiceResp(customerMaster);
	}


	@Override
	public ServiceResp getCustomersByUsername(String customerUsername) {
		// Input Validation
		if(Common.nullOrEmptyTrim(customerUsername)) {
			String description = "Username not defined.";
			return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
		}

		CustomerMaster customerMaster = customerMasterDao.findByUsername(customerUsername);

		// Validate Data Existence
		if(customerMaster==null) {
			String err = StringUtil.append("Invalid username [", customerUsername, "].");
			AppLog.log(CustomerServiceImpl.class, err);
			return Common.buildServiceRespError(ErrorCode.NOT_FOUND, err);
		}

		// Data Exist, Return Success
		return Common.buildServiceResp(customerMaster);
	}


	@Override
	public ServiceRespArray getCustomersByName(String customerName) {
		// Input Validation
		if(Common.nullOrEmptyTrim(customerName)) {
			String description = "The customer name cannot be blank.";
			return Common.buildServiceRespArrayError(ErrorCode.INVALID_INPUT, description);
		}

		List<CustomerMaster> customerMasterList = customerMasterDao.findByName(customerName);

		// Validate Data Existence
		if(customerMasterList==null || customerMasterList.isEmpty()) {
			String description =  StringUtil.append("No customer found with name [", customerName, "].");
			return Common.buildServiceRespArrayError(ErrorCode.NOT_FOUND, description);
		}
		// Data Exist, Return Success
		return Common.buildServiceRespArray(customerMasterList);
	}

}
