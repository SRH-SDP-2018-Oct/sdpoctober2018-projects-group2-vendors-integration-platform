package org.srh.vipapp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.srh.constants.ErrorCode;
import org.srh.util.Common;
import org.srh.util.HttpUtil;
import org.srh.util.StringUtil;
import org.srh.util.VipLog;
import org.srh.vipapp.hbm.dto.CustomerMaster;
import org.srh.vipapp.hbm.service.CustomerMasterService;
import org.srh.vipapp.hbm.service.CustomerMasterServiceImpl;

@Service
public class CustomerLoginRegistrationServiceImpl implements CustomerLoginRegistrationService {

	private CustomerMasterService customerMasterService = new CustomerMasterServiceImpl();

	@Override
	public JSONObject authenticate(HttpServletRequest req, HttpServletResponse resp, 
			String username, String pwd) {

		//
		if(Common.nullOrEmptyTrim(username)) {
			String description = "Username not defined.";
			return HttpUtil.errorResponse(resp, ErrorCode.INVALID_INPUT, description);
		}
		//
		if(Common.nullOrEmptyTrim(pwd)) {
			String description = "Password not defined.";
			return HttpUtil.errorResponse(resp, ErrorCode.INVALID_INPUT, description);
		}

		CustomerMaster customerMaster = customerMasterService.findByUsername(username);
		String description =  StringUtil.append("Invalid credentials for username [", username, "].");
		//
		if(customerMaster==null) {
			String err = StringUtil.append("Invalid username [", username, "].");
			VipLog.log(CustomerMasterServiceImpl.class, err);
			return HttpUtil.errorResponse(resp, ErrorCode.INVALID_CREDENTIALS, description);
		}
		// 
		String pwdEncrypted = StringUtil.sha256(pwd);
		if(!customerMaster.getPwd().equals(pwdEncrypted)) {
			String err = StringUtil.append("Invalid password for username [", username, "].");
			VipLog.log(CustomerMasterServiceImpl.class, err);
			return HttpUtil.errorResponse(resp, ErrorCode.INVALID_CREDENTIALS, description);
		}

		// Invalidate Previous Session
		req.getSession().invalidate();
		// Create new Session
		HttpSession session = req.getSession(true);

		String sessionId = session.getId();
		VipLog.print( StringUtil.append("New session created with id [", sessionId , "].") );

		return HttpUtil.successResponse(customerMaster, "sessionId", sessionId);
	}

}
