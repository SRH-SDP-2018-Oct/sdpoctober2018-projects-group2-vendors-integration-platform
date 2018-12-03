package org.srh.vipapp.service.impl;

import org.springframework.stereotype.Service;
import org.srh.bean.ServiceResp;
import org.srh.constants.ErrorCode;
import org.srh.util.Common;
import org.srh.util.StringUtil;
import org.srh.util.AppLog;
import org.srh.vipapp.hbm.dao.CustomerMasterDao;
import org.srh.vipapp.hbm.dao.impl.CustomerMasterDaoImpl;
import org.srh.vipapp.hbm.dto.CustomerMaster;
import org.srh.vipapp.service.CustomerLoginRegistrationService;

@Service
public class CustomerLoginRegistrationServiceImpl implements CustomerLoginRegistrationService {

	private CustomerMasterDao customerMasterDao = new CustomerMasterDaoImpl();

	@Override
	public ServiceResp authenticate(String username, String pwd) {

		//
		if(Common.nullOrEmptyTrim(username)) {
			String description = "Username not defined.";
			return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
		}
		//
		if(Common.nullOrEmptyTrim(pwd)) {
			String description = "Password not defined.";
			return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
		}

		CustomerMaster customerMaster = customerMasterDao.findByUsername(username);
		String description =  StringUtil.append("Invalid credentials for username [", username, "].");
		//
		if(customerMaster==null) {
			String err = StringUtil.append("Invalid username [", username, "].");
			AppLog.log(CustomerServiceImpl.class, err);
			return Common.buildServiceRespError(ErrorCode.INVALID_CREDENTIALS, description);
		}
		//
		String pwdEncrypted = StringUtil.sha256(pwd);
		if(!customerMaster.getPwd().equals(pwdEncrypted)) {
			String err = StringUtil.append("Invalid password for username [", username, "].");
			AppLog.log(CustomerServiceImpl.class, err);
			return Common.buildServiceRespError(ErrorCode.INVALID_CREDENTIALS, description);
		}

		return Common.buildServiceResp(customerMaster);
	}

}
