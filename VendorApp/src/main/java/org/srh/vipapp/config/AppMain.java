package org.srh.vipapp.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.srh.vendorapi.hbm.RootHB;
import org.srh.vendorapi.hbm.dto.UserMaster;

public class AppMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = RootHB.getSessionFactory();
		Session session = sessionFactory.openSession();
		UserMaster userMaster = session.find(UserMaster.class, 1);
		session.close();
		sessionFactory.close();
		System.exit(0);
	}
}
