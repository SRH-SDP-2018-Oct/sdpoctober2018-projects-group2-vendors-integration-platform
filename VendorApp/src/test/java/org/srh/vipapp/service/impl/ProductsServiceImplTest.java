package org.srh.vipapp.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.srh.vipapp.service.impl.ProductsServiceImpl;
import org.srh.bean.ServiceResp;
import org.srh.bean.ServiceRespArray;
import org.srh.constants.ErrorCode;
import org.srh.util.AppLog;
import org.srh.util.Common;
import org.srh.vipapp.hbm.dto.ProductType;
import org.srh.vipapp.hbm.dto.ProductsMaster;
import org.srh.vipapp.service.ProductsService;


public class ProductsServiceImplTest {

	private ProductsService productsService;

	@Before
	public void createServiceObject() {
		productsService = new ProductsServiceImpl();
	}

	@Test
	public void testGetAllProducts() {

		ServiceRespArray serviceRespArray = productsService.getAllProducts();
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
					ProductsMaster productsMaster = (ProductsMaster) list.get(0);
					if (productsMaster != null) {
						String message = "List returns the output";
						AppLog.print(message);
						assertTrue(message, true);
					} else {
						assertTrue("Non Matching Input and Output", false);
					}
				} else {
					assertTrue("Data is not instance of 'ProductsMaster'", false);
				}

			}
		} else {
			assertTrue("Invalid Service Response", false);
		}
	}

	@Test
	public void testGetProductByProductId() {
		String productId = "1";
		ServiceResp serviceResp = productsService.getProductByProductId(productId);
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
					ProductsMaster productsMaster = (ProductsMaster) data;
					int outputProductId = productsMaster.getProductId();
					String strValue = "";
					if (strValue == String.valueOf(outputProductId)) {
						String message = "Matching Input and Output";
						AppLog.print(message);
						assertTrue(message, true);
					} else {
						assertTrue("Non Matching Input and Output", false);
					}
				} else {
					assertTrue("Data is not instance of 'ProductsMaster'", false);
				}

			}
		} else {
			assertTrue("Invalid Service Response", false);
		}
	}

	@Test
	public void testGetProductsbyName() {
		String productName = "";
		ServiceRespArray serviceRespArray = productsService.getProductsbyName(productName);
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
					ProductsMaster productsMaster = (ProductsMaster) list.get(0);
					if (productsMaster != null) {
						String message = "List returns the output";
						AppLog.print(message);
						assertTrue(message, true);
					} else {

						assertTrue("Non Matching Input and Output", false);
					}
				} else {
					assertTrue("Data is not instance of 'ProductsMaster'", false);
				}

			}
		} else {
			assertTrue("Invalid Service Response", false);
		}
	}

	@Test
	public void testGetProductsByProductType() {
		String productId = "1";
		ServiceResp serviceResp = productsService.getProductByProductId(productId);
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
					ProductsMaster productsMaster = (ProductsMaster) data;
					ProductType outputProductTypeId = productsMaster.getProductTypeId();
					String strValue = "";
					if (strValue == String.valueOf(outputProductTypeId)) {
						String message = "Matching Input and Output";
						AppLog.print(message);
						assertTrue(message, true);
					} else {
						assertTrue("Non Matching Input and Output", false);
					}
				} else {
					assertTrue("Data is not instance of 'ProductsMaster'", false);
				}

			}
		} else {
			assertTrue("Invalid Service Response", false);
		}
	}

	@Test
	public void testGetProductsOnOffers() {
		ServiceRespArray serviceRespArray = productsService.getProductsOnOffers();
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
					ProductsMaster productsMaster = (ProductsMaster) list.get(0);
					if (productsMaster != null) {
						String message = "List returns the output";
						AppLog.print(message);
						assertTrue(message, true);
					} else {
						assertTrue("Non Matching Input and Output", false);
					}
				} else {
					assertTrue("Data is not instance of 'ProductsMaster'", false);
				}

			}
		} else {
			assertTrue("Invalid Service Response", false);
		}
	}

}
