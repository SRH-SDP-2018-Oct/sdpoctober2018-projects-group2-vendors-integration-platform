package org.srh.config;
import org.srh.vipapp.hbm.dto.*;

import java.util.List;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;
import org.srh.util.AppLog;
import org.srh.util.Common;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.impl.ApiStructureConstantsDaoImpl;
import org.srh.vipapp.hbm.dao.impl.ApiStructureDaoImpl;
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
		// 1. Get API Structure for the Vendor
		
		
		// 2. Get Product Data from Vendor API
		
		
		// 3. Associate the data with constant structure
		
		
		// 4. Save the data
	}


	public static void testHbmDaos() {
		List<?> list = new ApiStructureDaoImpl().getApiStructureOfVendor(1);
		Common.hidePojoDataList(list);
		JSONArray array = new JSONArray(list);
		AppLog.print(array);
	}


	public static void testHbmEntityId() {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		try {
			try ( Session session = RootHB.getSessionFactory().openSession(); ) {
				Object obj = Common.hidePojoData(session.find(VendorMaster.class, 2));
				jsonObject = new JSONObject(obj);
			}
		}
		catch(Exception ex) {
			AppLog.log(AppMain.class, ex);
		}
		finally {
			AppLog.print("JSONObject ===>>> "+jsonObject);
			AppLog.print("JSONArray ===>>> "+jsonArray);
			System.exit(0);
		}
	}


}
