package org.srh.config;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dto.UserMaster;
import org.srh.vipapp.hbm.service.UserMasterService;
import org.srh.vipapp.hbm.service.UserMasterServiceImpl;
import org.srh.vipapp.service.UserServiceImpl;


/**
 * Crash and Burn App
 * 
 * Date: 28 Nov 2018
 * @author Vivek
 */
public class AppMain {

	public static void main(String[] args) {
		testUserFunctionalities();
		System.exit(0);
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

		System.err.println(new UserServiceImpl().getUserById("1"));

		System.err.println(userMaster);
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
