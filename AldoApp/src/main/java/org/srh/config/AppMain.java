package org.srh.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONObject;
import org.srh.aldoapp.hbm.RootHB;
import org.srh.constants.KeyPairConstant;
import org.srh.util.AppLog;


/**
 * Crash and Burn App
 * 
 * Date: 02 Dec 2018
 * @author Vivek
 */
public class AppMain {



	public static void main(String[] args) {
		System.out.println(KeyPairConstant.PRODUCT_ID);
		System.out.println(KeyPairConstant.PRODUCT_ID);
		System.out.println(KeyPairConstant.PRODUCT_NAME);
	}


	// VIVEK
	static Object display() {
		SessionFactory sessionFactory = RootHB.getSessionFactory();
		Session session = sessionFactory.openSession();
		// BranchMaster branchMaster = session.find(BranchMaster.class, 1);
		session.close();
		sessionFactory.close();
		return null;
	}

}
