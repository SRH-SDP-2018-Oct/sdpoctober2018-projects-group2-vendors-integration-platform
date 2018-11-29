package org.srh.vendorapi.hbm;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RootHB {

	private static final String HIBERNATE_CFG = "hibernate.cfg.xml";

	private static final SessionFactory sessionFactory;

	static {
		Object obj = null;
		try {
			obj = new Configuration().configure(HIBERNATE_CFG).buildSessionFactory();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.exit(0);
		}
		sessionFactory = (SessionFactory) obj;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
