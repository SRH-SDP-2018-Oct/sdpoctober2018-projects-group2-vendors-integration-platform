package org.srh.config;
import org.srh.vipapp.hbm.dto.*;

import java.util.List;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.srh.util.AppLog;
import org.srh.util.Common;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.impl.ApiStructureDaoImpl;
import org.srh.vipapp.hbm.dao.impl.VendorBranchDaoImpl;
import org.srh.vipapp.hbm.dao.impl.VendorMasterDaoImpl;


/**
 * Crash and Burn App
 * 
 * Date: 28 Nov 2018
 * @author Vivek
 */
public class AppMain {


	public static void main(String[] args) {
		// ETL PROCESS
		String vendorName = "Netti";

		// Get Vendor
		VendorMaster vendorMaster = new VendorMasterDaoImpl().findByVendorName(vendorName);
		if(vendorMaster==null)
			return;

		List<VendorBranch> listBranchMaster = new VendorBranchDaoImpl().getAllBranches(vendorName);
		if(listBranchMaster==null)
			return;


		AppLog.print("========>>>>>>>>  "+ new JSONArray(listBranchMaster));
		
		// 1. Get API Structure for the Vendor
		List<ApiStructure> list = new ApiStructureDaoImpl().getApiStructureOfVendor(1);

		// 2. Get Product Data from Vendor API
		String data = "[{\"deleteFlag\":false,\"branchId\":1,\"productId\":1,\"productTypeId\":1,\"productDescription\":\"Energy : 197 KJ,1.5 %\",\"productName\":\"H-milk\",\"productPrice\":1},{\"deleteFlag\":false,\"branchId\":1,\"productId\":2,\"productTypeId\":2,\"productDescription\":\"Brand : Chiquita, Mainly grown in columbia,Slight sour to very sweet\",\"productName\":\"Banana\",\"productPrice\":2},{\"deleteFlag\":false,\"branchId\":1,\"productId\":3,\"productTypeId\":3,\"productDescription\":\"Origin : Spain Or Italy, Green or Dark Color, Store : In Refrigerator\",\"productName\":\"Broccoli\",\"productPrice\":1}]";
		JSONArray apiJSONArray = null;

		try {
			apiJSONArray = new JSONArray(data);
		}
		catch(JSONException ex) {
			AppLog.log(AppMain.class, "Parsing exception occurred while parsing API data of the Vendor.", ex);
			return;
		}


		int apiDataLen = apiJSONArray.length();
		if(apiDataLen==0)
			return ;

		JSONArray constructJSONArray = new JSONArray();

		for(int i=0; i<apiDataLen; i++) {
			JSONObject jsonObject = apiJSONArray.getJSONObject(i);
			JSONObject constructJSON = new JSONObject();
			for(ApiStructure apiStruct : list) {
				ApiStructureConstants apiStructConstants = apiStruct.getKeyConstantId();
				String apiKeyName = apiStruct.getKeyName();
				String constantName = apiStructConstants.getConstantName();
				String displayName = apiStructConstants.getDisplayName();
				constructJSON.put(constantName, jsonObject.get(apiKeyName));
				AppLog.print(displayName + " || " + constantName + " || " + apiKeyName);
			}
			constructJSONArray.put(constructJSON);
			AppLog.print("========>>>>>>>>  "+constructJSON);
		}


		// 4. Save the data
		

		AppLog.print("========>>>>>>>>  "+apiJSONArray);
		AppLog.print("========>>>>>>>>  "+constructJSONArray);
		System.exit(0);
	}


	public static void testHbmDaos() {
		List<?> list = new ApiStructureDaoImpl().getApiStructureOfVendor(1);
		Common.hidePojoDataList(list);
		JSONArray array = new JSONArray(list);
		AppLog.print(array);
		System.exit(0);
	}


	public static void testHbmEntityId() {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		try {
			try ( Session session = RootHB.getSessionFactory().openSession(); ) {
				Object obj = Common.hidePojoData(session.find(VendorBranch.class, 1));
				jsonObject = new JSONObject(obj);
			}
		}
		catch(Exception ex) {
			AppLog.log(AppMain.class, ex);
		}
		finally {
			AppLog.print("JSONObject ===>>> "+jsonObject);
			AppLog.print("JSONArray ===>>> "+jsonArray);
		}
	}


}
