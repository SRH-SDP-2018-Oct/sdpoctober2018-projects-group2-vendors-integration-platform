package org.srh.nettiapp.service.impl;

import static org.srh.constants.KeyPairConstant.*;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.srh.bean.ServiceRespArray;
import org.srh.constants.ErrorCode;
import org.srh.nettiapp.hbm.dao.ProductMasterDao;
import org.srh.nettiapp.hbm.dao.impl.ProductMasterDaoImpl;
import org.srh.nettiapp.hbm.dto.ProductMaster;
import org.srh.nettiapp.service.ProductService;
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
					.put(PRODUCT_ID.toString(), product.getProductId())
					.put(PRODUCT_NAME.toString(), product.getProductName())
					.put(PRODUCT_TYPE_ID.toString(), product.getProductTypeId().getProductTypeId())
					.put(PRODUCT_DESCRIPTION.toString(), product.getProductDescription())
					.put(PRODUCT_PRICE.toString(), product.getProductPrice().toString())
					.put(BRANCH_ID.toString(), product.getBranchId().getBranchId())
					.put(DELETE_FLAG.toString(), product.getDeleteFlag());
			jsonArray.put(jsonObject);
		}
		return Common.buildServiceRespArray(jsonArray);
	}

}
