package org.srh.vipapp.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.srh.constants.ErrorCode;
import org.srh.util.Common;
import org.srh.util.HttpUtil;
import org.srh.util.NumberUtil;
import org.srh.util.StringUtil;
import org.srh.vipapp.hbm.dto.CustomerMaster;
import org.srh.vipapp.hbm.service.CustomerMasterService;
import org.srh.vipapp.hbm.service.impl.CustomerMasterServiceImpl;
import org.srh.vipapp.service.CustomerService;

/**
 * Serivce Implementation of {@link CustomerService}.  <br/>
 * Date: 01 Dec 2018
 * @author Vivek
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerMasterService customerMasterService = new CustomerMasterServiceImpl();


	@Override
	public JSONObject getCustomerById(HttpServletResponse resp, String customerId) {
		//
		Long cId = NumberUtil.getLong(customerId);
		if(cId==null) {
			String description = StringUtil.append("The customer id [", customerId, "] is invalid integer.");
			return HttpUtil.errorResponse(resp, ErrorCode.INVALID_INPUT, description);
		}

		CustomerMaster customerMaster = customerMasterService.findById(cId.longValue());
		//
		if(customerMaster==null) {
			String description =  StringUtil.append("No customer found with id [", customerId, "].");
			return HttpUtil.errorResponse(resp, ErrorCode.NOT_FOUND, description);
		}
		// 
		return HttpUtil.successResponse(customerMaster);
	}


	@Override
	public JSONObject getCustomersByName(HttpServletResponse resp, String customerName) {
		//
		if(Common.nullOrEmptyTrim(customerName)) {
			String description = "The customer name cannot be blank.";
			return HttpUtil.errorResponse(resp, ErrorCode.INVALID_INPUT, description);
		}

		List<CustomerMaster> customerMaster = customerMasterService.findByName(customerName);
		//
		if(customerMaster==null || customerMaster.isEmpty()) {
			String description =  StringUtil.append("No customer found with name [", customerName, "].");
			return HttpUtil.errorResponse(resp, ErrorCode.NOT_FOUND, description);
		}
		// 
		return HttpUtil.successResponseArray(customerMaster);
	}

}
