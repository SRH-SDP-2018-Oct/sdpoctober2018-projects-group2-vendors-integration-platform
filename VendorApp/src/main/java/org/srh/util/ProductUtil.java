package org.srh.util;

import java.math.BigDecimal;
import java.util.Map;

import org.json.JSONObject;
import org.srh.constants.KeyPairConstants;
import org.srh.vipapp.hbm.dto.ProductType;
import org.srh.vipapp.hbm.dto.ProductsMaster;
import org.srh.vipapp.hbm.dto.UserMaster;
import org.srh.vipapp.hbm.dto.VendorBranch;

public final class ProductUtil {

	private ProductUtil() { }


	public static ProductsMaster getProductFromJSON(JSONObject productJSON, JSONObject apiJSON, UserMaster userMaster) {
		ProductsMaster productsMaster = new ProductsMaster();
		// Offers
		productsMaster.setHasAnOffer(false);
		productsMaster.setOfferDetail("");
		// JSON Data
		productsMaster.setApiData(apiJSON.toString());
		productsMaster.setProductData(productJSON.toString());
		// Price
		BigDecimal price = new BigDecimal(productJSON.get(KeyPairConstants.PRODUCT_PRICE).toString());
		productsMaster.setProductPrice(price);
		// Set Attributes
		productsMaster.setProductId(productJSON.getInt(KeyPairConstants.PRODUCT_ID) );
		productsMaster.setProductName(productJSON.getString(KeyPairConstants.PRODUCT_NAME) );
		productsMaster.setProductDescription(productJSON.getString(KeyPairConstants.PRODUCT_DESC));
		// Set User Data
		productsMaster.setModifiedBy(userMaster);
		productsMaster.setCreatedBy(userMaster);
		return productsMaster;
	}


	public static ProductsMaster setProductType(ProductsMaster productsMaster, JSONObject productJSON,
			Map<Integer,ProductType> mapProductType) {
		// Get And Set Product Type
		Integer productTypeId = productJSON.getInt(KeyPairConstants.PRODUCT_TYPE);
		ProductType productType = mapProductType.get(productTypeId);		
		productsMaster.setProductTypeId(productType);
		return productsMaster;
	}


	public static ProductsMaster setVendorData(ProductsMaster productsMaster, JSONObject productJSON,
			Map<Integer,VendorBranch> mapVendorBranch) {
		// Get and Set Vendor Branch
		Integer vendorBranchId = productJSON.getInt(KeyPairConstants.PRODUCT_BRANCH);
		VendorBranch vendorBranch = mapVendorBranch.get(vendorBranchId);
		productsMaster.setBranchId(vendorBranch);
		productsMaster.setVendorId(vendorBranch.getVendorId());
		return productsMaster;
	}

}
