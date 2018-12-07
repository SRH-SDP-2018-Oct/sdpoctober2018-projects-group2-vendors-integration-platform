package org.srh.config;


import org.srh.vipapp.hbm.dto.*;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;
import org.srh.util.AppLog;
import org.srh.util.Common;
import org.srh.vipapp.hbm.RootHB;


/**
 * Crash and Burn App
 * 
 * Date: 28 Nov 2018
 * @author Vivek
 */
public class AppMain {



	public static void main(String[] args) {
		// testCustomerFunctinalities();
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		try {

			try ( Session session = RootHB.getSessionFactory().openSession(); ) {
				Object obj = Common.hidePojoData(session.find(ApiStructure.class, 2));
				jsonObject = new JSONObject(obj);
			}
			
			/*List list = new ApiStructureDaoImpl().getVendorsApiStructure(1);
			AppLog.print(list);
			*/
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
