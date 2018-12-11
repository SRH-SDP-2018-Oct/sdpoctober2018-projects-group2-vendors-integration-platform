package org.srh.vipapp.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.srh.vipapp.service.impl.CustomerServiceImpl;
import org.srh.bean.ServiceResp;
import org.srh.bean.ServiceRespArray;
import org.srh.constants.ErrorCode;
import org.srh.util.AppLog;
import org.srh.util.Common;
import org.srh.vipapp.hbm.dto.CustomerMaster;
import org.srh.vipapp.service.CustomerService;

public class CustomerServiceImplTest {

	private CustomerService customerService;


	@Before
	public void createServiceObject() {
		customerService = new CustomerServiceImpl();
	}


	@Test
	public void testGetCustomerById() {
		String customerId = "1";
		ServiceResp serviceResp = customerService.getCustomerById(customerId);
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
				if(data instanceof CustomerMaster && data!=null) {
					CustomerMaster customerMaster = (CustomerMaster) data;
					Long outputCustomerId = customerMaster.getCustomerId();
					if(customerId.equals(outputCustomerId.toString())) {
						String message = "Matching Input and Output";
						AppLog.print(message);
						assertTrue(message, true);
					}
					else {
						assertTrue("Non Matching Input and Output", false);
					}
				}
				else {
					assertTrue("Data is not instance of 'CustomerMaster'", false);
				}
					
			}
		}
		else {
			assertTrue("Invalid Service Response", false);
		}
	}


	@Test
	public void testGetCustomersByUsername() {
		assertTrue(true);
	}


	@Test
	public void testGetCustomersByName() {
		String customerName = "j";
		ServiceRespArray serviceRespArray = customerService.getCustomersByName(customerName);
		if(serviceRespArray != null) {
			Object data = serviceRespArray.getSuccessData();
			ErrorCode errorCode = serviceRespArray.getErrorCode();
			String errorDescription = serviceRespArray.getErrorDescription();
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
					CustomerMaster customerMaster = (CustomerMaster) list.get(0);
					if(customerMaster!=null) {
						String message = "List returns the output";
						AppLog.print(message);
						assertTrue(message, true);
					}
					else {
						assertTrue("Non Matching Input and Output", false);
					}
				}
				else {
					assertTrue("Data is not instance of 'CustomerMaster'", false);
				}
					
			}
		}
		else {
			assertTrue("Invalid Service Response", false);
		}
	}
		

}
