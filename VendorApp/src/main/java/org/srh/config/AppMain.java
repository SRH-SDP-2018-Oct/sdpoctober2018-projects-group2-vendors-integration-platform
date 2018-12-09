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
import org.srh.vipapp.activity.ProductActivity;
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
		ProductActivity productActivity = new ProductActivity();
		productActivity.registerProducts("Netti");
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
