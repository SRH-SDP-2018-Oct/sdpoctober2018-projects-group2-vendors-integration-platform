package org.srh.vipapp.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.srh.bean.ServiceResp;
import org.srh.bean.ServiceRespArray;
import org.srh.constants.ErrorCode;
import org.srh.util.AppLog;
import org.srh.util.Common;
import org.srh.vipapp.hbm.dto.CustomerCart;
import org.srh.vipapp.hbm.dto.CustomerMaster;
import org.srh.vipapp.hbm.dto.ProductsMaster;
import org.srh.vipapp.service.CustomerCartService;

/**
 * @author Shraddha
 *
 */
public class CustomerCartServiceImplTest {

	private CustomerCartService customerCartService;

	@Before
	public void createServiceObject() {
		customerCartService = new CustomerCartServiceImpl();
	}

	@Test
	public void testGetAllCarts() {
		ServiceRespArray serviceRespArray = customerCartService.getAllCarts();
		if (serviceRespArray != null) {
			Object data = serviceRespArray.getSuccessData();
			ErrorCode errorCode = serviceRespArray.getErrorCode();
			String errorDescription = serviceRespArray.getErrorDescription();
			//
			if (data == null) {
				if (errorCode != null && !Common.nullOrEmptyTrim(errorDescription)) {
					AppLog.print(errorDescription);
					assertTrue(errorDescription, true);
				} else {
					assertTrue("Error Code and Description not defined", false);
				}
			} else {
				if (data instanceof List && data != null) {
					@SuppressWarnings("rawtypes")
					List list = (List) data;
					if (list.isEmpty()) {
						String message = "Entry not present in the database with the given input";
						AppLog.print(message);
						assertTrue(message, true);
					}
					CustomerCart customerCart = (CustomerCart) list.get(0);
					if (customerCart != null) {
						String message = "List returns the output";
						AppLog.print(message);
						assertTrue(message, true);
					} else {
						assertTrue("Non Matching Input and Output", false);
					}
				} else {
					assertTrue("Data is not instance of 'CustomerCart'", false);
				}

			}
		} else {
			assertTrue("Invalid Service Response", false);
		}
	}

	@Test
	public void testGetCartsByValidCartId() {
		String cartId = "1";
		ServiceResp serviceResp = customerCartService.getCartsByCartId(cartId);
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
				if (data instanceof CustomerCart && data != null) {
					CustomerCart customerCart = (CustomerCart) data;
					long outputProductId = customerCart.getCartId();
					String strValue = "";
					if (strValue == String.valueOf(outputProductId)) {
						String message = "Matching Input and Output";
						AppLog.print(message);
						assertTrue(message, true);
					} else {
						assertTrue("Non Matching Input and Output", false);
					}
				} else {
					assertTrue("Data is not instance of 'CustomerCart'", false);
				}

			}
		} else {
			assertTrue("Invalid Service Response", false);
		}
	}

	public void testGetCartsByInvalidCartId() {
		String cartId = "9";
		ServiceResp serviceResp = customerCartService.getCartsByCartId(cartId);
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
				if (data instanceof CustomerCart && data != null) {
					CustomerCart customerCart = (CustomerCart) data;
					long outputProductId = customerCart.getCartId();
					String strValue = "";
					if (strValue == String.valueOf(outputProductId)) {
						String message = "Matching Input and Output";
						AppLog.print(message);
						assertTrue(message, true);
					} else {
						assertTrue("Non Matching Input and Output", false);
					}
				} else {
					assertTrue("Data is not instance of 'CustomerCart'", false);
				}

			}
		} else {
			assertTrue("Invalid Service Response", false);
		}
	}

	public void testGetCartsByNullCartId() {
		String cartId = null;
		ServiceResp serviceResp = customerCartService.getCartsByCartId(cartId);
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
				if (data instanceof CustomerCart && data != null) {
					CustomerCart customerCart = (CustomerCart) data;
					long outputProductId = customerCart.getCartId();
					String strValue = "";
					if (strValue == String.valueOf(outputProductId)) {
						String message = "Matching Input and Output";
						AppLog.print(message);
						assertTrue(message, true);
					} else {
						assertTrue("Non Matching Input and Output", false);
					}
				} else {
					assertTrue("Data is not instance of 'CustomerCart'", false);
				}

			}
		} else {
			assertTrue("Invalid Service Response", false);
		}
	}

	@Test
	public void testGetCartsByValidUserId() {
		String customerId = "1";
		ServiceRespArray serviceResp = customerCartService.getCartsByUserId(customerId);
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
				if (data instanceof CustomerMaster && data != null) {
					CustomerMaster customerId1 = (CustomerMaster) data;
					long outputCustomerId = customerId1.getCustomerId();
					String strValue = "";
					if (strValue == String.valueOf(outputCustomerId)) {
						String message = "Matching Input and Output";
						AppLog.print(message);
						assertTrue(message, true);
					} else {
						assertTrue("Non Matching Input and Output", false);
					}
				} else {
					assertTrue("Data is not instance of 'CustomerCart'", false);
				}

			}
		} else {
			assertTrue("Invalid Service Response", false);
		}
	}

	public void testGetCartsByInvalidUserId() {
		String customerId = "9";
		ServiceRespArray serviceResp = customerCartService.getCartsByUserId(customerId);
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
				if (data instanceof CustomerMaster && data != null) {
					CustomerMaster customerId1 = (CustomerMaster) data;
					long outputCustomerId = customerId1.getCustomerId();
					String strValue = "";
					if (strValue == String.valueOf(outputCustomerId)) {
						String message = "Matching Input and Output";
						AppLog.print(message);
						assertTrue(message, true);
					} else {
						assertTrue("Non Matching Input and Output", false);
					}
				} else {
					assertTrue("Data is not instance of 'CustomerCart'", false);
				}

			}
		} else {
			assertTrue("Invalid Service Response", false);
		}
	}

	public void testGetCartsByNullUserId() {
		String customerId = null;
		ServiceRespArray serviceResp = customerCartService.getCartsByUserId(customerId);
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
				if (data instanceof CustomerMaster && data != null) {
					CustomerMaster customerId1 = (CustomerMaster) data;
					long outputCustomerId = customerId1.getCustomerId();
					String strValue = "";
					if (strValue == String.valueOf(outputCustomerId)) {
						String message = "Matching Input and Output";
						AppLog.print(message);
						assertTrue(message, true);
					} else {
						assertTrue("Non Matching Input and Output", false);
					}
				} else {
					assertTrue("Data is not instance of 'CustomerCart'", false);
				}

			}
		} else {
			assertTrue("Invalid Service Response", false);
		}
	}

	@Test
	public void testAddProduct() {
		String data1 = "";
		String customerId = "1";
		ServiceResp serviceResp = customerCartService.addProduct(data1, customerId);
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
				if (data instanceof ProductsMaster && data != null) {
					ProductsMaster productId = (ProductsMaster) data;
					int outputproductId = productId.getProductId();
					String strValue = "";
					if (strValue == String.valueOf(outputproductId)) {
						String message = "Matching Input and Output";
						AppLog.print(message);
						assertTrue(message, true);
					} else {
						assertTrue("Non Matching Input and Output", false);
					}
				} else {
					assertTrue("Data is not instance of 'CustomerCart'", false);
				}

			}
		} else {
			assertTrue("Invalid Service Response", false);
		}
	}

	@Test
	public void testAddAllProduct() {
		String data1 = "";
		String customerId = "1";
		ServiceResp serviceResp = customerCartService.addAllProduct(data1, customerId);
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
				if (data instanceof List && data != null) {
					@SuppressWarnings("rawtypes")
					List list = (List) data;
					if (list.isEmpty()) {
						String message = "Entry not present in the database with the given input";
						AppLog.print(message);
						assertTrue(message, true);
					}
					CustomerCart customerCart = (CustomerCart) list.get(0);
					if (customerCart != null) {
						String message = "List returns the output";
						AppLog.print(message);
						assertTrue(message, true);
					} else {
						assertTrue("Non Matching Input and Output", false);
					}
				} else {
					assertTrue("Data is not instance of 'CustomerCart'", false);
				}

			}
		} else {
			assertTrue("Invalid Service Response", false);
		}
	}

}
