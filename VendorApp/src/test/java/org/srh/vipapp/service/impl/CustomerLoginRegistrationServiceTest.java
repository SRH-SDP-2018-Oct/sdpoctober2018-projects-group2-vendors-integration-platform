/**
 * 
 */
package org.srh.vipapp.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.srh.bean.ServiceResp;
import org.srh.constants.ErrorCode;
import org.srh.util.AppLog;
import org.srh.util.Common;
import org.srh.vipapp.service.CustomerLoginRegistrationService;

/**
 * @author Maitreyee
 *
 */
public class CustomerLoginRegistrationServiceTest {
	
	private CustomerLoginRegistrationService customerLoginRegistrationService;
	
	@Before
	public void createServiceObject() {
		customerLoginRegistrationService = new CustomerLoginRegistrationServiceImpl();
	}

	/**
	 * Test method for {@link org.srh.vipapp.service.CustomerLoginRegistrationService#authenticate(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAuthenticate() {
		String username = "John";
		String pwd = "Hello@123";
		ServiceResp serviceResp = customerLoginRegistrationService.authenticate(username, pwd);
		if(serviceResp != null) {
			Object data = serviceResp.getSuccessData();
			ErrorCode errorCode = serviceResp.getErrorCode();
			String errorDescription = serviceResp.getErrorDescription();
			// 
			if(data==null) {
				if(errorCode!=null && !Common.nullOrEmptyTrim(errorDescription)) {
					AppLog.print(errorDescription);
					assertTrue(errorDescription, true);
				}
				else {
					assertTrue("Error Code and Description not defined", false);
				}
			}
			else {
				if(data instanceof List && data!=null) {
					@SuppressWarnings("rawtypes")
					List list = (List) data;
					if(list.isEmpty()) {
						String message = "Entry not present in the database with the given input";
						AppLog.print(message);
						assertTrue(message, true);
					}
					
					else {
						assertTrue("Non Matching Input and Output", false);
					}
				}
					
			}
		}
		else {
			assertTrue("Invalid Service Response", false);
		}
	}

}
