package org.srh.vipapp.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;
import org.srh.bean.ServiceResp;
import org.srh.constants.ErrorCode;
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
		//
		Long cId = NumberUtil.getLong(customerId);
		if(cId==null) {
			String description = StringUtil.append("The customer id [", customerId, "] is invalid integer.");
			return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
		}

		CustomerMaster customerMaster = customerMasterDao.findById(cId.longValue());
		//
		if(customerMaster==null) {
			String description =  StringUtil.append("No customer found with id [", customerId, "].");
			return Common.buildServiceRespError(ErrorCode.NOT_FOUND, description);
		}
		// 
		return Common.buildServiceResp(customerMaster);
	}


	@Override
	public ServiceResp getCustomersByName(String customerName) {
		//
		if(Common.nullOrEmptyTrim(customerName)) {
			String description = "The customer name cannot be blank.";
			return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
		}

		List<CustomerMaster> customerMasterList = customerMasterDao.findByName(customerName);
		//
		if(customerMasterList==null || customerMasterList.isEmpty()) {
			String description =  StringUtil.append("No customer found with name [", customerName, "].");
			return Common.buildServiceRespError(ErrorCode.NOT_FOUND, description);
		}
		// 
		return Common.buildServiceResp(customerMasterList);
	}

}
