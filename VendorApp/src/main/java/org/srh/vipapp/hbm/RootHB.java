package org.srh.vipapp.hbm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.srh.util.AppLog;
import org.srh.vipapp.hbm.dao.impl.UserMasterDaoImpl;
import org.srh.vipapp.hbm.dto.UserMaster;


/**
 * Title: ROOT Class to perform the task related the Hibernate Framework
 * Date: 28 Nov 2018
 * @author Vivek
 */
public class RootHB {

	private static final String HIBERNATE_CFG = "hibernate.cfg.xml";

	private static final SessionFactory SESSION_FACTORY;
	private static final UserMaster USER_MASTER_SYSTEM;

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
			AppLog.log(RootHB.class, "Hibernate Root Class Initialization failed.", ex);
			System.exit(0);
		}
		SESSION_FACTORY = (SessionFactory) obj;

		Object objUser = null;
		try {
			objUser = new UserMasterDaoImpl().findSystemUser();
		}
		catch(Exception ex) {
			AppLog.log(RootHB.class, "Hibernate Root Class Initialization failed.", ex);
			System.exit(0);
		}
		USER_MASTER_SYSTEM = (UserMaster) objUser;
	}


	/**
	 * Returns the {@link SessionFactory} object.
	 * @return sessionFactory {@link SessionFactory}
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
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


	public static UserMaster getSystemUser() {
		return USER_MASTER_SYSTEM;
	}

}
