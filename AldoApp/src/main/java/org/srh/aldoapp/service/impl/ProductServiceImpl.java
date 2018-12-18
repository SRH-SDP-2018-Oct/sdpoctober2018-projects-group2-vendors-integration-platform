package org.srh.aldoapp.service.impl;

import static org.srh.constants.KeyPairConstant.*;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.srh.aldoapp.hbm.dao.ProductMasterDao;
import org.srh.aldoapp.hbm.dao.impl.ProductMasterDaoImpl;

import org.srh.aldoapp.service.ProductService;
import org.srh.aldoapp.hbm.dto.ProductMaster;
import org.srh.bean.ServiceRespArray;
import org.srh.constants.ErrorCode;
import org.srh.util.Common;

/**
 * Serivce Implementation of {@link ProductService}.  <br/>
 * Date: 11 Dec 2018
 * @author Shraddha
 */
@Service
public class ProductServiceImpl implements ProductService {

	ProductMasterDao productMasterDao = new ProductMasterDaoImpl();

	@Override
	public ServiceRespArray getAllProducts() {
		List<ProductMaster> productList = productMasterDao.getAllProducts();
		//
		int size = 0;
		if(productList==null || (size=productList.size())==0) {
			String description =  "No products are available.";
			return Common.buildServiceRespArrayError(ErrorCode.NOT_FOUND, description);
		}
		// 
		JSONArray jsonArray = new JSONArray();
		for(int i=0; i<size; i++) {
			ProductMaster product = productList.get(i);
			JSONObject jsonObject = new JSONObject()
					.put(PRODUCT_ID.key(), product.getProductId())
					.put(PRODUCT_NAME.key(), product.getProductName())
					.put(PRODUCT_TYPE.key(), product.getProductTypeId().getProductTypeId())
					.put(PRODUCT_DESCRIPTION.key(), product.getProductDescription())
					.put(PRODUCT_PRICE.key(), product.getProductPrice().toString())
					.put(BRANCH.key(), product.getBranchId().getBranchId())
					.put(DELETEFLAG.key(), product.getDeleteFlag());
			jsonArray.put(jsonObject);
		}
		return Common.buildServiceRespArray(jsonArray);
	}

}
