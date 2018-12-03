package org.srh.vipapp.service.impl;

import org.springframework.stereotype.Service;
import org.srh.bean.ServiceResp;
import org.srh.constants.ErrorCode;
import org.srh.util.Common;
import org.srh.util.NumberUtil;
import org.srh.util.StringUtil;
import org.srh.vipapp.hbm.dao.UserMasterDao;
import org.srh.vipapp.hbm.dao.impl.UserMasterDaoImpl;
import org.srh.vipapp.hbm.dto.UserMaster;
import org.srh.vipapp.service.UserService;

/**
 * Serivce Implementation of {@link UserService}.  <br/>
 * Date: 30 Nov 2018
 * @author Vivek
 */
@Service
public class UserServiceImpl implements UserService {

	private UserMasterDao userMasterDao = new UserMasterDaoImpl();

	@Override
	public ServiceResp getUserById(String userId) {
		//
		Integer uId = NumberUtil.getInteger(userId);
		if(uId==null) {
			String description = StringUtil.append("The user id [", userId, "] is invalid integer.");
			return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
		}

		UserMaster userMaster = userMasterDao.findById(uId.intValue());
		//
		if(userMaster==null) {
			String description =  StringUtil.append("No user found with id [", userId, "].");
			return Common.buildServiceRespError(ErrorCode.NOT_FOUND, description);
		}
		// 
		return Common.buildServiceResp(userMaster);
	}

	
}
