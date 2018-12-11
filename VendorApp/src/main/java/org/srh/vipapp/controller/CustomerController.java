package org.srh.vipapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.srh.bean.ServiceResp;
import org.srh.bean.ServiceRespArray;
import org.srh.constants.ErrorCode;
import org.srh.util.AppLog;
import org.srh.util.Common;
import org.srh.util.HttpUtil;
import org.srh.util.StringUtil;
import org.srh.vipapp.hbm.dto.CustomerMaster;
import org.srh.vipapp.service.CustomerLoginRegistrationService;
import org.srh.vipapp.service.CustomerService;

/**
 * Rest Controller to serve the API/HTTP Call related to the Application Customer.
 * Date: 01 Dec 2018
 * @author Vivek
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;


	@RequestMapping(path="/id/{customerId}", method=RequestMethod.GET)
	public String getCustomerById(@PathVariable String customerId, HttpServletResponse resp) {
		ServiceResp serviceResp = customerService.getCustomerById(customerId);
		return HttpUtil.buildResponse(resp, serviceResp).toString();
	}


	@RequestMapping(path="/username/{customerUsername}", method=RequestMethod.GET)
	public String getCustomerByUsername(@PathVariable String customerUsername, HttpServletResponse resp) {
		ServiceResp serviceResp = customerService.getCustomersByUsername(customerUsername);
		return HttpUtil.buildResponse(resp, serviceResp).toString();
	}


	@RequestMapping(path="/name/{customerName}", method=RequestMethod.GET)
	public String getCustomerByName(@PathVariable String customerName, HttpServletResponse resp) {
		ServiceRespArray serviceResp = customerService.getCustomersByName(customerName);
		return HttpUtil.buildResponseArray(resp, serviceResp).toString();
	}



	@Autowired
	private CustomerLoginRegistrationService customerLoginRegistrationService;

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String customerLogin(@RequestParam String username, @RequestParam String pwd, 
			HttpServletResponse resp, HttpServletRequest req) {

		// Authenticate the user
		ServiceResp serviceResp = customerLoginRegistrationService.authenticate(username, pwd);

		// Error is not null if the request or user invalid
		ErrorCode errorCode = serviceResp.getErrorCode();
		if(errorCode!=null) {
			return HttpUtil.errorResponse(resp, errorCode, serviceResp.getErrorDescription()).toString();
		}

		// Invalidate Previous Session
		req.getSession().invalidate();
		// Create new Session
		HttpSession session = req.getSession(true);

		String sessionId = session.getId();
		AppLog.print( StringUtil.append("New session created with id [", sessionId , "].") );

		Common.setCustomerId(session, ((CustomerMaster)serviceResp.getSuccessData()).getCustomerId());
		return HttpUtil.successResponse(serviceResp.getSuccessData(), "sessionId", sessionId).toString();
	}

}
