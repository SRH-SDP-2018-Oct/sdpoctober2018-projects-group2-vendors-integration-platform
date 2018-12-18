package org.srh.vipapp.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.srh.util.AppLog;
import org.srh.util.Common;
import org.srh.util.ProductUtil;
import org.srh.util.StringUtil;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.impl.ApiStructureDaoImpl;
import org.srh.vipapp.hbm.dao.impl.ProductTypeDaoImpl;
import org.srh.vipapp.hbm.dao.impl.UserMasterDaoImpl;
import org.srh.vipapp.hbm.dao.impl.VendorBranchDaoImpl;
import org.srh.vipapp.hbm.dao.impl.VendorMasterDaoImpl;
import org.srh.vipapp.hbm.dto.ApiStructure;
import org.srh.vipapp.hbm.dto.ApiStructureConstants;
import org.srh.vipapp.hbm.dto.ProductType;
import org.srh.vipapp.hbm.dto.ProductsMaster;
import org.srh.vipapp.hbm.dto.UserMaster;
import org.srh.vipapp.hbm.dto.VendorBranch;
import org.srh.vipapp.hbm.dto.VendorMaster;


/**
 * Performs the activity to save the product using the vendor APIs.  <br/>
 * 09 Dec 2018
 * @author Vivek
 */

public class ProductActivity {

	private String strSep = "********************************************************************************";
	private String strUnderline = "--------------------------------------------------------";



	public boolean registerProducts(String vendorName) {

		/* *** GET VENDOR DATA *** */
		VendorMaster vendorMaster = new VendorMasterDaoImpl().findByVendorName(vendorName);
		if(vendorMaster==null)
			return false;
		return registerProducts(vendorMaster);
	}



	private boolean registerProducts(VendorMaster vendorMaster) {

		/* ********************************************************************** */
		/* ****************** GET PRODUCT DATA FROM VENDOR API ****************** */
		/* ********************************************************************** */

		String data = getProductData(vendorMaster.getVendorName());
		if(Common.nullOrEmptyTrim(data)) {
			AppLog.log(ProductActivity.class, "Data not received from the vendor.");
			return false;
		}


		JSONArray apiJSONArray = null;
		try {
			JSONObject jsonObject = new JSONObject(data);
			apiJSONArray = jsonObject.getJSONArray("data");
			AppLog.print(apiJSONArray);
		}
		catch(JSONException ex) {
			AppLog.log(ProductActivity.class, "Parsing exception occurred while parsing API data of the Vendor.", ex);
			return false;
		}

		if(apiJSONArray.length()==0) {
			AppLog.log(ProductActivity.class, "Blank data received from the vendor.");
			return false;
		}

		return registerProductsForVendor(vendorMaster, apiJSONArray);
	}



	/* ******************************************************* */
	/* ****************** GET CONSTANT DATA ****************** */
	/* ******************************************************* */

	private boolean registerProductsForVendor(VendorMaster vendorMaster, JSONArray apiJSONArray) {

		/* *** 1. GET BRANCH DATA *** */
		List<VendorBranch> listBranchMaster = new VendorBranchDaoImpl().getAllBranches(vendorMaster.getVendorId());
		if(listBranchMaster==null || listBranchMaster.isEmpty())
			return false;

		// Map Vendor Branch
		int vendorBranchesCount = listBranchMaster.size();
		Map<Integer,VendorBranch> mapVendorBranch = new HashMap<>(vendorBranchesCount);
		for(int i=vendorBranchesCount-1; i>-1; i--) {
			VendorBranch vb = listBranchMaster.get(i);
			mapVendorBranch.put(vb.getBranchId(), vb);
		}


		/* *** 2. GET ALL PRODUCT TYPES FOR THE GIVEN VENDOR *** */
		List<ProductType> listProductType = new ProductTypeDaoImpl().getAllProductType(vendorMaster.getVendorId());
		if(listProductType==null || listProductType.isEmpty())
			return false;

		int productTypeCount = listProductType.size();
		Map<Integer,ProductType> mapProductType = new HashMap<>(productTypeCount);
		for(int i=productTypeCount-1; i>-1; i--) {
			ProductType pt = listProductType.get(i);
			mapProductType.put(pt.getProductTypeId(), pt);
		}


		/* ********************************************************************** */
		/* ****************** GET API STRUCTURE FOR THE VENDOR ****************** */
		/* ********************************************************************** */

		List<ApiStructure> listApiStruct = new ApiStructureDaoImpl().getApiStructureOfVendor(vendorMaster.getVendorId());

		// SAVING TASK
		return saveProducts(apiJSONArray, listApiStruct, mapProductType, mapVendorBranch);
	}



	private boolean saveProducts(JSONArray apiJSONArray, List<ApiStructure> listApiStruct,
			Map<Integer,ProductType> mapProductType, Map<Integer,VendorBranch> mapVendorBranch) {


		/* *********************************************************************** */
		/* ****************** PRODUCT DATA TRANSFORMATION LOGIC ****************** */
		/* *********************************************************************** */
		int apiDataLen = apiJSONArray.length();

		Session session = RootHB.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		List<JSONObject> jsonList = new ArrayList<>(apiDataLen*2);
		int apiCount = 0;
		try {
			// 
			/* *** GET USER *** */
			UserMaster user = new UserMasterDaoImpl().findSystemUser(session);
			if(user==null)
				return false;

			int lenStructAPI = listApiStruct.size();
			ProductsMaster productsMaster;
			for(; apiCount<apiDataLen; apiCount++) {
				JSONObject apiJSON = apiJSONArray.getJSONObject(apiCount);
				JSONObject productJSON = new JSONObject();
				productsMaster = createProductEntity(listApiStruct, lenStructAPI, apiJSON, productJSON, user, mapProductType, mapVendorBranch);
				session.save(productsMaster);
				jsonList.add(apiJSON);
				jsonList.add(productJSON);
			}
			transaction.commit();
			printLog(jsonList);
			return true;
		}
		catch(Exception ex) {
			AppLog.print(ProductActivity.class, ex);
			transaction.rollback();
			printLogError(apiJSONArray, apiCount);
			return false;
		}
		finally {
			session.close();
		}
	}



	private ProductsMaster createProductEntity(List<ApiStructure> listApiStruct, int lenStructAPI,
			JSONObject apiJSON, JSONObject productJSON, UserMaster user,
			Map<Integer,ProductType> mapProductType, Map<Integer,VendorBranch> mapVendorBranch) {
		// 
		for(int i=0; i<lenStructAPI; i++) {
			ApiStructure apiStruct = listApiStruct.get(i);
			ApiStructureConstants apiStructConstants = apiStruct.getKeyConstantId();
			String apiKeyName = apiStruct.getKeyName();
			String constantName = apiStructConstants.getConstantName();
			productJSON.put(constantName, apiJSON.get(apiKeyName));
		}
		ProductsMaster productsMaster = ProductUtil.getProductFromJSON(productJSON, apiJSON, user);
		ProductUtil.setProductType(productsMaster, productJSON, mapProductType);
		ProductUtil.setVendorData(productsMaster, productJSON, mapVendorBranch);
		return productsMaster;
	}



	private void printLog(List<JSONObject> jsonList) {
		// Success Logging
		int len = jsonList.size();
		if(len>1) {
			for(int i=0; i<len; i+=2) {
				JSONObject apiJSON = jsonList.get(i);
				JSONObject productJSON = jsonList.get(i+1);
				AppLog.print(ProductActivity.class, StringUtil.append(strSep,"\n",strSep));
				AppLog.print(ProductActivity.class, StringUtil.append("DATA CONVERSION", "\n", strUnderline));
				AppLog.print(ProductActivity.class, StringUtil.append("API DATA ===>>> ", apiJSON, "\n", strUnderline));
				AppLog.print(ProductActivity.class, StringUtil.append("PRODUCT DATA ===>>> ", productJSON, "\n", strUnderline));
				AppLog.print(ProductActivity.class, StringUtil.append(strSep,"\n",strSep));
			}
		}
	}



	private void printLogError(JSONArray jsonArrayAPI, int counter) {
		// Error Logging
		int len = jsonArrayAPI.length();
		for(int i=counter; i<len; i++) {
			JSONObject apiJSON = jsonArrayAPI.getJSONObject(i);
			AppLog.print(ProductActivity.class, StringUtil.append(strSep,"\n",strSep));
			AppLog.print(ProductActivity.class, StringUtil.append("DATA CONVERSION ERROR WITH FOLLOWING API DATA",strUnderline));
			AppLog.print(ProductActivity.class, StringUtil.append("API DATA ===>>> ", apiJSON, strUnderline));
			AppLog.print(ProductActivity.class, StringUtil.append(strSep,"\n",strSep));
		}
	}




	private String getProductData(String vendorName) {
		String strURL = null;
		if("netti".equalsIgnoreCase(vendorName))
			strURL = "http://localhost:8080/nettiapp/products/all";
		else
			strURL = "http://localhost:8080/aldoapp/products/all";
		return new ApiConnection(strURL).toString();
	}
}
