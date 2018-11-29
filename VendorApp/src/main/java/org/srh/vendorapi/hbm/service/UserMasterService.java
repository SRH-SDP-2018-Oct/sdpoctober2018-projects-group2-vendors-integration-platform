package org.srh.vendorapi.hbm.service;

import java.util.List;

import org.srh.vendorapi.hbm.dto.UserMaster;

/**
 * HBM Service to perform task related to {@link UserMaster} entity.  <br/>
 * Date: 29 Nov 2018
 * @author Vivek
 */
public interface UserMasterService {

	/**
	 * Gets the {@link UserMaster} entity with the given 'userId'.
	 * @param userId {@link Integer}
	 * @return userMaster {@link UserMaster}
	 */
	public UserMaster findById(int userId);

	/**
	 * Returns all the {@link UserMaster} entities from persistence database
	 * @return userMasterList {@link List<UserMaster>}
	 */
	public List<UserMaster> getAllUsers();

	/**
	 * Gets the {@link UserMaster} entity with the given 'username'.
	 * @param username {@link String}
	 * @return userMaster {@link UserMaster}
	 */
	public UserMaster findByUsername(String username);

}
