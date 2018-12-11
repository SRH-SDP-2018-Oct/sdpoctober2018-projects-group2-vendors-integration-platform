package org.srh.vipapp.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.srh.vipapp.service.impl.UserServiceImpl;
import org.srh.bean.ServiceResp;
import org.srh.constants.ErrorCode;
import org.srh.util.AppLog;
import org.srh.util.Common;
import org.srh.vipapp.hbm.dto.UserMaster;
import org.srh.vipapp.service.UserService;

public class UserServiceImplTest {

	private UserService userService;

	@Before
	public void createServiceObject() {
		userService = new UserServiceImpl();
	}

	@Test
	public void testGetUserById() {

		String userId = "1";
		ServiceResp serviceResp = userService.getUserById(userId);
		if (serviceResp != null) {
			Object data = serviceResp.getSuccessData();
			ErrorCode errorCode = serviceResp.getErrorCode();
			String errorDescription = serviceResp.getErrorDescription();
			//
			if (data == null) {
				if (errorCode != null && !Common.nullOrEmptyTrim(errorDescription)) {
					AppLog.print(errorDescription);
					assertTrue(errorDescription, true);
				} else {
					assertTrue("Error Code and Description not defined", false);
				}
			} else {
				if (data instanceof UserMaster && data != null) {
					UserMaster userMaster = (UserMaster) data;
					int outputUserId = userMaster.getId();
					String strValue = "";
					if (strValue == String.valueOf(outputUserId)) {
						String message = "Matching Input and Output";
						AppLog.print(message);
						assertTrue(message, true);
					} else {
						assertTrue("Non Matching Input and Output", false);
					}
				} else {
					assertTrue("Data is not instance of 'UserMaster'", false);
				}

			}
		} else {
			assertTrue("Invalid Service Response", false);
		}
	}

}
