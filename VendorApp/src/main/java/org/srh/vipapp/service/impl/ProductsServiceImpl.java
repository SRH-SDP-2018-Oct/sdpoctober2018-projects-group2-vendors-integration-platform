package org.srh.vipapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.srh.bean.ServiceResp;
import org.srh.bean.ServiceRespArray;
import org.srh.constants.ErrorCode;
import org.srh.util.AppLog;
import org.srh.util.Common;
import org.srh.util.NumberUtil;
import org.srh.util.StringUtil;
import org.srh.vipapp.hbm.dao.ProductsMasterDao;
import org.srh.vipapp.hbm.dao.impl.ProductsMasterDaoImpl;
import org.srh.vipapp.hbm.dto.ProductsMaster;
import org.srh.vipapp.service.ProductsService;

/**
 * Service Implementation of {@link ProductsService}.  <br/>
 * Date: 05 Dec 2018
 * @author Anglita
 */
@Service
public class ProductsServiceImpl implements ProductsService{

	private ProductsMasterDao productsMasterDao = new ProductsMasterDaoImpl();

	@Override
	public ServiceRespArray getAllProducts() {
		List<ProductsMaster> allProductsList = productsMasterDao.getAllProducts();

		// Validate Data Existence
		if(allProductsList==null || allProductsList.isEmpty()) {
			String description =  "No Products found.";
			return Common.buildServiceRespArrayError(ErrorCode.NOT_FOUND, description);
		}

		return Common.buildServiceRespArray(allProductsList);
	}

	@Override
	public ServiceResp getProductByProductId(String productId) {
		// Input Validation
		Integer prodId = NumberUtil.getInteger(productId);
		if(prodId==null) {
			String description = StringUtil.append("The product id [", productId, "] is an invalid integer.");
			return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
		}

		ProductsMaster productsById = productsMasterDao.findById(prodId);

		// Validate Data Existence
		if(productsById==null) {
			String description =  StringUtil.append("No product found with id [", productId, "].");
			return Common.buildServiceRespError(ErrorCode.NOT_FOUND, description);
		}

		// Data Exist, Return Success
		return Common.buildServiceResp(productsById);
	}

	@Override
	public ServiceRespArray getProductsbyName(String productName) {
		// Input Validation
		if(Common.nullOrEmptyTrim(productName)) {
			String description = "Product name not found.";
			return Common.buildServiceRespArrayError(ErrorCode.INVALID_INPUT, description);
		}

		List<ProductsMaster> productsByNameList = productsMasterDao.findbyProductName(productName);

		// Validate Data Existence
		if(productsByNameList==null) {
			String err = StringUtil.append("Invalid product name [", productName, "].");
			AppLog.log(ProductsServiceImpl.class, err);
			return Common.buildServiceRespArrayError(ErrorCode.NOT_FOUND, err);
		}

		// Data Exist, Return Success
		return Common.buildServiceRespArray(productsByNameList);
	}

	@Override
	public ServiceRespArray getProductsByProductType(String productTypeName) {
		// Input Validation
		if(Common.nullOrEmptyTrim(productTypeName)) {
			String description = StringUtil.append("The product type [", productTypeName, "] is an invalid.");
			return Common.buildServiceRespArrayError(ErrorCode.INVALID_INPUT, description);
		}

		List<ProductsMaster> productsByProductTypeList = productsMasterDao.getProductsByProductType(productTypeName);

		// Validate Data Existence
		if(productsByProductTypeList==null) {
			String description =  StringUtil.append("No product found with id [", productTypeName, "].");
			return Common.buildServiceRespArrayError(ErrorCode.NOT_FOUND, description);
		}

		// Data Exist, Return Success
		return Common.buildServiceRespArray(productsByProductTypeList);
	}


	@Override
	public ServiceRespArray getProductsOnOffers() {
		List<ProductsMaster> productsOnOffersList = productsMasterDao.getAllProductsOnOffer();
		if(productsOnOffersList == null) {
			String err = "No Products on Offers.";
			AppLog.log(ProductsServiceImpl.class, err);
			return Common.buildServiceRespArrayError(ErrorCode.NOT_FOUND, err);
		}
		return Common.buildServiceRespArray(productsOnOffersList);
	}


	@Override
	public ServiceRespArray getSearchProducts(String productName, String filter) {
		// Input Validation
		if(Common.nullOrEmptyTrim(productName)) {
			String description = "Product name not found.";
			return Common.buildServiceRespArrayError(ErrorCode.INVALID_INPUT, description);
		}

		List<ProductsMaster> productsByNameList = productsMasterDao.findbyProductName(productName);

		// Validate Data Existence
		if(productsByNameList==null) {
			String err = StringUtil.append("Invalid product name [", productName, "].");
			AppLog.log(ProductsServiceImpl.class, err);
			return Common.buildServiceRespArrayError(ErrorCode.NOT_FOUND, err);
		}

		// Data Exist, Return Success
		return Common.buildServiceRespArray(productsByNameList);
	}
}
