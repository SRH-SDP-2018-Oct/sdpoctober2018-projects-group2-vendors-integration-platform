package org.srh.vipapp.service;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.srh.constants.ErrorCode;
import org.srh.util.HttpUtil;
import org.srh.util.NumberUtil;
import org.srh.util.StringUtil;
import org.srh.vipapp.hbm.dto.UserMaster;
import org.srh.vipapp.hbm.service.UserMasterService;
import org.srh.vipapp.hbm.service.UserMasterServiceImpl;

/**
 * Serivce Implementation of {@link UserService}.  <br/>
 * Date: 30 Nov 2018
 * @author Vivek
 */
@Service
public class UserServiceImpl implements UserService {

	private UserMasterService userMasterService = new UserMasterServiceImpl();

	@Override
	public JSONObject getUserById(String userId, HttpServletResponse resp) {
		//
		Integer uId = NumberUtil.getInteger(userId);
		if(uId==null) {
			String description = StringUtil.append("The user id [", userId, "] is invalid integer.");
			return HttpUtil.errorResponse(resp, ErrorCode.INVALID_INPUT, description);
		}

		UserMaster userMaster = userMasterService.findById(uId.intValue());
		//
		if(userMaster==null) {
			String description =  StringUtil.append("No user found with id [", userId, "].");
			return HttpUtil.errorResponse(resp, ErrorCode.NOT_FOUND, description);
		}
		// 
		return HttpUtil.successResponse(userMaster);
	}

	
}
