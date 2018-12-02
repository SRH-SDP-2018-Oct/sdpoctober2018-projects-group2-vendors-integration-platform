package org.srh.nettiapp.hbm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Title: ROOT Class to perform the task related the Hibernate Framework
 * Date: 28 Nov 2018
 * @author Vivek
 */
public class RootHB {

	private static final String HIBERNATE_CFG = "hibernate.cfg.xml";

	private static final SessionFactory sessionFactory;

	/**
	 * Perform the Framework Configuration from HBM file
	 * and build the {@link SessionFactory} out of the {@link Configuration}
	 */
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


	/**
	 * Returns the {@link SessionFactory} object.
	 * @return sessionFactory {@link SessionFactory}
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	/**
	 * Closes the object of {@link Session} passed as an input.
	 * If the connection is not null and closed within the method then 'true' is returned otherwise false.
	 * @param session {@link Session}
	 * @return closeFlag {@link Boolean}
	 */
	public static boolean closeSession(Session session) {
		if(session!=null && session.isOpen()) {
			session.close();
			return true;
		}
		return false;
	}

}
