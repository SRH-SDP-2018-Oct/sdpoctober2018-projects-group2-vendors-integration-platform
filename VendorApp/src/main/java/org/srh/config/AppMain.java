package org.srh.config;
import org.srh.vipapp.hbm.dto.*;
import org.srh.vipapp.service.impl.CustomerCartServiceImpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
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
			AppLog.print(new JSONObject(new CustomerCartServiceImpl().getFrquentlyBoughtProducts("1")));
			// vendorDataETL();
			frequentlyBought();
		}
		catch(Exception ex) {
			AppLog.log(AppMain.class, ex);
		}
		finally {
			System.exit(0);
		}
	}


	private static void frequentlyBought() {
		String queryString = StringUtil.append("SELECT cp.productId, COUNT(*), cp.*  " ,
				" FROM cart_product cp ",
				" INNER JOIN customer_cart cc ON cc.cartId = cp.cartId\r\n" + 
				" WHERE cc.customerId = :customerId ",
				" GROUP BY cp.productId ");
		Session session = RootHB.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		Query<CartProduct> query = session.createSQLQuery(queryString).addEntity("cp", CartProduct.class);
		query.setParameter("customerId", 1);
		List<CartProduct> list = query.getResultList();
		AppLog.print(new JSONArray(list));
	}


	private static void sortedLocation() {
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
				" ORDER BY distance ");
		Session session = RootHB.getSessionFactory().openSession();
		Query query = session.createSQLQuery(queryString).addEntity("pm", ProductsMaster.class);
		query.setParameter("userLatitude", "49.4140614");
		query.setParameter("userLongitude", "8.6536843");
		// query.setParameter(0, "");
		// '49.4140614'
		//
		List list = query.getResultList();
		AppLog.print(new JSONArray(list));
	}


	private static void vendorDataETL() {
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
