package org.srh.config;
import org.srh.vipapp.hbm.dto.*;
import org.srh.vipapp.service.impl.CustomerCartServiceImpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
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
import org.srh.vipapp.hbm.dao.impl.CustomerCartDaoImpl;
import org.srh.vipapp.hbm.dao.impl.CustomerMasterDaoImpl;
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
		try {
			/*CustomerMaster customerMaster = new CustomerMasterDaoImpl().findById(1);
			// sortedLocation( "milk", "49.4140614", "8.6536843");
			sortedLocation( "milk", customerMaster.getDefaultLocationLat(), customerMaster.getDefaultLocationLon());*/
			vendorDataETL();
		}
		catch(Exception ex) {
			AppLog.log(AppMain.class, ex);
		}
		finally {
			System.exit(0);
		}
	}


	// 
	private static void sortedLocation(String productName, BigDecimal latitude, BigDecimal longitude) {
		String queryString = StringUtil.append("SELECT " ,
				"   ( 6371 * ACOS ( COS ( RADIANS(:userLatitude) ) " ,
				"    * COS ( RADIANS( vm.locationLat ) ) " ,
				"    * COS ( RADIANS( vm.locationLon ) - RADIANS(:userLongitude) ) " ,
				"    + SIN ( RADIANS(:userLatitude) ) " ,
				"    * SIN ( RADIANS( vm.locationLat ) )",
				"   ))  AS distance,",
				"   pm.* ",
				" FROM products_master pm ",
				" INNER JOIN vendor_branches vm ON vm.id = pm.branchId ",
				" WHERE pm.productName LIKE :productName ",
				" ORDER BY distance ");
		Session session = RootHB.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		NativeQuery<ProductsMaster> nativeQuery = session.createSQLQuery(queryString);
		Query<ProductsMaster> query = nativeQuery.addEntity("pm", ProductsMaster.class);
		query.setParameter("productName", StringUtil.append("%", productName, "%"));
		query.setParameter("userLatitude", latitude);
		query.setParameter("userLongitude", longitude);
		List<ProductsMaster> list = query.getResultList();
		AppLog.print(new JSONArray(list));
		session.close();
	}


	private static void vendorDataETL() {
		ProductActivity productActivity = new ProductActivity();
		productActivity.registerProducts("Netti");
		//productActivity.registerProducts("Aldo");
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
