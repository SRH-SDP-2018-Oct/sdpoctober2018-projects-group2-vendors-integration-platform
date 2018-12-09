package org.srh.config;
import org.srh.vipapp.hbm.dto.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.srh.constants.ValueConstants;
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


/**
 * Crash and Burn App
 * 
 * Date: 28 Nov 2018
 * @author Vivek
 */
public class AppMain {


	public static void main(String[] args) {

		/* ******************************************************* */
		/* ****************** GET CONSTANT DATA ****************** */
		/* ******************************************************* */

		String vendorName = "Netti";
		String username = ValueConstants.USER_SYSTEM;

		/* *** 1. GET VENDOR DATA *** */
		VendorMaster vendorMaster = new VendorMasterDaoImpl().findByVendorName(vendorName);
		if(vendorMaster==null)
			return;

		/* *** 2. GET BRANCH DATA *** */
		List<VendorBranch> listBranchMaster = new VendorBranchDaoImpl().getAllBranches(vendorMaster.getVendorId());
		if(listBranchMaster==null || listBranchMaster.isEmpty())
			return;

		// Map Vendor Branch
		int vendorBranchesCount = listBranchMaster.size();
		Map<Integer,VendorBranch> mapVendorBranch = new HashMap<>(vendorBranchesCount);
		for(int i=vendorBranchesCount-1; i>-1; i--) {
			VendorBranch vb = listBranchMaster.get(i);
			mapVendorBranch.put(vb.getBranchId(), vb);
		}


		/* *** 3. GET ALL PRODUCT TYPES FOR THE GIVEN VENDOR *** */
		List<ProductType> listProductType = new ProductTypeDaoImpl().getAllProductType(vendorMaster.getVendorId());
		if(listProductType==null || listProductType.isEmpty())
			return;

		int productTypeCount = listProductType.size();
		Map<Integer,ProductType> mapProductType = new HashMap<>(productTypeCount);
		for(int i=productTypeCount-1; i>-1; i--) {
			ProductType pt = listProductType.get(i);
			mapProductType.put(pt.getProductTypeId(), pt);
		}

		/* *** 4. GET USER *** */
		UserMaster userMaster = new UserMasterDaoImpl().findByUsername(username);
		if(userMaster==null)
			return;


		/* ********************************************************************** */
		/* ****************** GET API STRUCTURE FOR THE VENDOR ****************** */
		/* ********************************************************************** */

		List<ApiStructure> list = new ApiStructureDaoImpl().getApiStructureOfVendor(1);


		/* ********************************************************************** */
		/* ****************** GET PRODUCT DATA FROM VENDOR API ****************** */
		/* ********************************************************************** */

		String data = "[{\"deleteFlag\":false,\"branchId\":1,\"productId\":1,\"productTypeId\":1,\"productDescription\":\"Energy : 197 KJ,1.5 %\",\"productName\":\"H-milk\",\"productPrice\":1},{\"deleteFlag\":false,\"branchId\":1,\"productId\":2,\"productTypeId\":2,\"productDescription\":\"Brand : Chiquita, Mainly grown in columbia,Slight sour to very sweet\",\"productName\":\"Banana\",\"productPrice\":2},{\"deleteFlag\":false,\"branchId\":1,\"productId\":3,\"productTypeId\":3,\"productDescription\":\"Origin : Spain Or Italy, Green or Dark Color, Store : In Refrigerator\",\"productName\":\"Broccoli\",\"productPrice\":1}]";
		JSONArray apiJSONArray = null;

		try {
			apiJSONArray = new JSONArray(data);
			AppLog.print(apiJSONArray);
		}
		catch(JSONException ex) {
			AppLog.log(AppMain.class, "Parsing exception occurred while parsing API data of the Vendor.", ex);
			return;
		}


		int apiDataLen = apiJSONArray.length();
		if(apiDataLen==0)
			return ;



		/* *********************************************************************** */
		/* ****************** PRODUCT DATA TRANSFORMATION LOGIC ****************** */
		/* *********************************************************************** */


		// 
		Session session = RootHB.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			for(int i=0; i<apiDataLen; i++) {
				JSONObject apiJSON = apiJSONArray.getJSONObject(i);
				JSONObject productJSON = new JSONObject();
				for(ApiStructure apiStruct : list) {
					ApiStructureConstants apiStructConstants = apiStruct.getKeyConstantId();
					String apiKeyName = apiStruct.getKeyName();
					String constantName = apiStructConstants.getConstantName();
					productJSON.put(constantName, apiJSON.get(apiKeyName));
				}
				ProductsMaster productsMaster = ProductUtil.getProductFromJSON(productJSON, apiJSON, userMaster);
				ProductUtil.setProductType(productsMaster, productJSON, mapProductType);
				ProductUtil.setVendorData(productsMaster, productJSON, mapVendorBranch);
				session.save(productsMaster);
				// Log Conversion
				String strSep = "********************************************************************************";
				String strUnderline = "--------------------------------------------------------";
				AppLog.print(AppMain.class, StringUtil.append(strSep,"\n",strSep));
				AppLog.print(AppMain.class, StringUtil.append("DATA CONVERSION",strUnderline));
				AppLog.print(AppMain.class, StringUtil.append("API DATA ===>>> ", apiJSON, strUnderline));
				AppLog.print(AppMain.class, StringUtil.append("PRODUCT DATA ===>>> ", productJSON, strUnderline));
				AppLog.print(AppMain.class, StringUtil.append(strSep,"\n",strSep));
			}
			transaction.commit();
		}
		catch(Exception ex) {
			AppLog.print(AppMain.class, ex);
			transaction.rollback();
		}
		finally {
			session.close();
			System.exit(0);
		}
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
