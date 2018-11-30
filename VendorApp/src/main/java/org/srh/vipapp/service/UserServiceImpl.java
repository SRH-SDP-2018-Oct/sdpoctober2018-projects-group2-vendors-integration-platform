package org.srh.vipapp.service;

import org.springframework.stereotype.Service;
import org.srh.util.NumberUtil;
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
	public String getUserById(String userId) {
		Integer uId = NumberUtil.getInteger(userId);
		if(uId==null)
			return "{}";
		UserMaster userMaster = userMasterService.findById(uId.intValue());
		return userMaster==null ? "{}": userMaster.toString();
	}

	
}
