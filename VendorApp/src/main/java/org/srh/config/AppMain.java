package org.srh.config;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.srh.util.HttpUtil;
import org.srh.util.VipLog;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dto.UserMaster;
import org.srh.vipapp.hbm.service.CustomerMasterService;
import org.srh.vipapp.hbm.service.CustomerMasterServiceImpl;
import org.srh.vipapp.hbm.service.UserMasterService;
import org.srh.vipapp.hbm.service.UserMasterServiceImpl;

import com.google.common.hash.Hashing;


/**
 * Crash and Burn App
 * 
 * Date: 28 Nov 2018
 * @author Vivek
 */
public class AppMain {



	public static void main(String[] args) {
		// testCustomerFunctinalities();
		String sha256 = Hashing.sha256().hashString("Hello@135", StandardCharsets.UTF_8).toString();
		VipLog.print(sha256);
		System.exit(0);
	}



	static void testCustomerFunctinalities() {
		CustomerMasterService hbmService = new CustomerMasterServiceImpl();
		VipLog.print(AppMain.class, new JSONArray(hbmService.findByName("john")));
	}



	// VIVEK
	static void testUserFunctionalities() {
		UserMasterService userMasterService = new UserMasterServiceImpl();

		// Get User By Id
		UserMaster userMaster = userMasterService.findById(1);

		// Get All User
		List<UserMaster> userMasterList = userMasterService.getAllUsers();

		// Get User By UserName
		UserMaster userMaster2 = userMasterService.findByUsername("system");

		System.err.println(HttpUtil.successResponse(null));
		System.err.println(HttpUtil.successResponse(userMaster));
		System.err.println(userMasterList);
		System.err.println(userMaster2);
	}



	// VIVEK
	static void displaySystemUser() {
		SessionFactory sessionFactory = RootHB.getSessionFactory();
		Session session = sessionFactory.openSession();
		UserMaster userMaster = session.find(UserMaster.class, 1);
		System.err.println(userMaster);
		session.close();
		sessionFactory.close();
	}

}
