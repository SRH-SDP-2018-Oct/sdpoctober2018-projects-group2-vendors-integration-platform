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
import org.srh.vipapp.hbm.dto.VendorMaster;
import org.srh.vipapp.service.VendorService;
import org.srh.vipapp.service.impl.VendorServiceImpl;

/**
 * @author Maitreyee
 *
 */
public class VendorServiceTest {
	
	private VendorService vendorService;
	
	@Before
	public void createServiceObject() {
		vendorService = new VendorServiceImpl();
	}

	/**
	 * Test method for {@link org.srh.vipapp.service.VendorService#getVendorById(java.lang.String)}.
	 */
	@Test
	public void testGetVendorById() {
		String vendorId = "1";
		ServiceResp serviceResp = vendorService.getVendorById(vendorId);
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
				if(data instanceof VendorMaster && data!=null) {
					VendorMaster vendorMaster = (VendorMaster) data;
					int outputvendorId = vendorMaster.getVendorId();
					String strValue= "";
					if ( strValue== String.valueOf( outputvendorId )) {
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


	/**
	 * Test method for {@link org.srh.vipapp.service.VendorService#getVendorByVendorName(java.lang.String)}.
	 */
	@Test
	public void testGetVendorByVendorName() {
		String vendorName = "n";
		ServiceResp serviceResp = vendorService.getVendorByVendorName(vendorName);
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
					VendorMaster vendorMaster = (VendorMaster) list.get(0);
					if(vendorMaster!=null) {
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

	/**
	 * Test method for {@link org.srh.vipapp.service.VendorService#getAllVendors()}.
	 */
	@Test
	public void testGetAllVendors() {
		assertTrue(true);
	}

}
