package org.srh.vipapp.hbm.dao;

import java.util.List;

import org.hibernate.Session;
import org.srh.vipapp.hbm.dto.UserMaster;


/**
 * HBM DAO to perform task related to {@link UserMaster} entity.  <br/>
 * Date: 29 Nov 2018
 * @author Vivek
 */
public interface UserMasterDao {

	static final String ROOT_USER = "root";
	static final String SYSTEM_USER = "system";

	/**
	 * Gets the {@link UserMaster} entity with the given 'userId'.
	 * @param userId {@link Integer}
	 * @return userMaster {@link UserMaster}
	 */
	UserMaster findById(int userId);

	/**
	 * Returns all the {@link UserMaster} entities from persistence database
	 * @return userMasterList {@link List<UserMaster>}
	 */
	List<UserMaster> getAllUsers();

	/**
	 * Gets the {@link UserMaster} entity with the given 'username'.
	 * @param username {@link String}
	 * @return userMaster {@link UserMaster}
	 */
	UserMaster findByUsername(String username);

	/**
	 * Gets the system user from database.
	 * @return systemUserMaster {@link UserMaster}
	 */
	UserMaster findSystemUser();

	/**
	 * Gets the system user from database.
	 * @param session {@link Session}
	 * @return systemUserMaster {@link UserMaster}
	 */
	UserMaster findSystemUser(Session session);

}