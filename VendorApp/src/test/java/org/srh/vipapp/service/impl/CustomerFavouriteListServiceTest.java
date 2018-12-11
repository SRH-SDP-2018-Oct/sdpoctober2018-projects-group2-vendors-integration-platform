/**
 * 
 */
package org.srh.vipapp.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.srh.bean.ServiceResp;
import org.srh.constants.ErrorCode;
import org.srh.util.AppLog;
import org.srh.util.Common;
import org.srh.vipapp.hbm.dto.CustomerFavouriteList;
import org.srh.vipapp.hbm.dto.FavouriteListProduct;
import org.srh.vipapp.hbm.dto.ProductsMaster;
import org.srh.vipapp.service.CustomerFavouriteListService;

/**
 * @author Maitreyee
 *
 */
public class CustomerFavouriteListServiceTest {

	private CustomerFavouriteListService customerFavouriteListService;

	@Before
	public void createServiceObject() {
		customerFavouriteListService = new CustomerFavouriteListServiceImpl();
	}

	/**
	 * Test method for
	 * {@link org.srh.vipapp.service.CustomerFavouriteListService#getFavouriteListById(java.lang.String)}.
	 */
	@Test
	public void testGetFavouriteListByValidId() {
		String listId = "1";
		ServiceResp serviceResp = customerFavouriteListService.getFavouriteListById(listId);
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
				if (data instanceof CustomerFavouriteList && data != null) {
					CustomerFavouriteList customerFavoriteList = (CustomerFavouriteList) data;
					Long outputlistId = customerFavoriteList.getListId();
					if (listId.equals(outputlistId.toString())) {
						String message = "Matching Input and Output";
						AppLog.print(message);
						assertTrue(message, true);
					} else {
						assertTrue("Non Matching Input and Output", false);
					}
				} else {
					assertTrue("Data is not instance of 'CustomerMaster'", false);
				}
			}
		} else {
			assertTrue("Invalid Service Response", false);
		}
	}

	public void testGetFavouriteListByInvalidId() {
		String listId = "9";
		ServiceResp serviceResp = customerFavouriteListService.getFavouriteListById(listId);
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
				if (data instanceof CustomerFavouriteList && data != null) {
					CustomerFavouriteList customerFavoriteList = (CustomerFavouriteList) data;
					Long outputlistId = customerFavoriteList.getListId();
					if (listId.equals(outputlistId.toString())) {
						String message = "Matching Input and Output";
						AppLog.print(message);
						assertTrue(message, true);
					} else {
						assertTrue("Non Matching Input and Output", false);
					}
				} else {
					assertTrue("Data is not instance of 'CustomerMaster'", false);
				}
			}
		} else {
			assertTrue("Invalid Service Response", false);
		}
	}

	/**
	 * Test method for
	 * {@link org.srh.vipapp.service.CustomerFavouriteListService#getFavouriteListByCustomerId(java.lang.String)}.
	 */
	@Test
	public void testGetFavouriteListByValidCustomerId() {
		String customerId = "1";
		ServiceResp serviceResp = customerFavouriteListService.getFavouriteListByCustomerId(customerId);
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
				if (data instanceof CustomerFavouriteList && data != null) {
					CustomerFavouriteList customerFavoriteList = (CustomerFavouriteList) data;
					Long outputlistId = customerFavoriteList.getListId();
					if (customerId.equals(outputlistId.toString())) {
						String message = "Matching Input and Output";
						AppLog.print(message);
						assertTrue(message, true);
					} else {
						assertTrue("Non Matching Input and Output", false);
					}
				} else {
					assertTrue("Data is not instance of 'CustomerMaster'", false);
				}
			}
		} else {
			assertTrue("Invalid Service Response", false);
		}
	}

	public void testGetFavouriteListByInvalidCustomerId() {
		String customerId = "9";
		ServiceResp serviceResp = customerFavouriteListService.getFavouriteListByCustomerId(customerId);
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
				if (data instanceof CustomerFavouriteList && data != null) {
					CustomerFavouriteList customerFavoriteList = (CustomerFavouriteList) data;
					Long outputlistId = customerFavoriteList.getListId();
					if (customerId.equals(outputlistId.toString())) {
						String message = "Matching Input and Output";
						AppLog.print(message);
						assertTrue(message, true);
					} else {
						assertTrue("Non Matching Input and Output", false);
					}
				} else {
					assertTrue("Data is not instance of 'CustomerMaster'", false);
				}
			}
		} else {
			assertTrue("Invalid Service Response", false);
		}
	}

	/**
	 * Test method for
	 * {@link org.srh.vipapp.service.CustomerFavouriteListService#addProductToFavouriteList(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddProductToFavouriteList() {
		String data = "";
		String customerId = "1";
		ServiceResp serviceResp = customerFavouriteListService.addProductToFavouriteList(data, customerId);
		if (serviceResp != null) {
			Object successData = serviceResp.getSuccessData();
			ErrorCode errorCode = serviceResp.getErrorCode();
			String errorDescription = serviceResp.getErrorDescription();
			//
			if (successData == null) {
				if (errorCode != null && !Common.nullOrEmptyTrim(errorDescription)) {
					AppLog.print(errorDescription);
					assertTrue(errorDescription, true);
				} else {
					assertTrue("Error Code and Description not defined", false);
				}
			} else {
				if (successData instanceof FavouriteListProduct && successData != null) {
					FavouriteListProduct favouriteListProduct = (FavouriteListProduct) successData;
					ProductsMaster outputproductId = favouriteListProduct.getProductId();
					if (customerId.equals(outputproductId.toString())) {
						String message = "Matching Input and Output";
						AppLog.print(message);
						assertTrue(message, true);
					} else {
						assertTrue("Non Matching Input and Output", false);
					}
				} else {
					assertTrue("Data is not instance of 'CustomerMaster'", false);
				}
			}
		} else {
			assertTrue("Invalid Service Response", false);
		}
	}

	/**
	 * Test method for
	 * {@link org.srh.vipapp.service.CustomerFavouriteListService#addProductsToFavouriteList(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddProductsToFavouriteList() {
		String data = "";
		String customerId = "1";
		ServiceResp serviceResp = customerFavouriteListService.addProductsToFavouriteList(data, customerId);
		if (serviceResp != null) {
			Object successData = serviceResp.getSuccessData();
			ErrorCode errorCode = serviceResp.getErrorCode();
			String errorDescription = serviceResp.getErrorDescription();
			//
			if (successData == null) {
				if (errorCode != null && !Common.nullOrEmptyTrim(errorDescription)) {
					AppLog.print(errorDescription);
					assertTrue(errorDescription, true);
				} else {
					assertTrue("Error Code and Description not defined", false);
				}
			} else {
				if (successData instanceof FavouriteListProduct && successData != null) {
					FavouriteListProduct favouriteListProduct = (FavouriteListProduct) successData;
					ProductsMaster outputproductId = favouriteListProduct.getProductId();
					if (customerId.equals(outputproductId.toString())) {
						String message = "Matching Input and Output";
						AppLog.print(message);
						assertTrue(message, true);
					} else {
						assertTrue("Non Matching Input and Output", false);
					}
				} else {
					assertTrue("Data is not instance of 'CustomerMaster'", false);
				}
			}
		} else {
			assertTrue("Invalid Service Response", false);
		}
	}

}
