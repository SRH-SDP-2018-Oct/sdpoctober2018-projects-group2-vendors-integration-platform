package org.srh.vipapp.hbm.hql;

import org.srh.vipapp.hbm.dto.UserMaster;

/**
 * Contains HQL for the {@link UserMaster} entity.
 * Date: 01 Dec 2018
 * @author Vivek
 */
public final class UserMasterQuery {

	private UserMasterQuery() { }

	public static final String GET_ALL_USERS_$N = "GET_ALL_USER";
	public static final String GET_ALL_USERS_$Q = "FROM UserMaster "
			+ " WHERE deleteFlag=0";

	public static final String FIND_USER_BY_USERNAME_$P1 = "userName";
	public static final String FIND_USER_BY_USERNAME_$N = "FIND_USER_BY_USERNAME";
	public static final String FIND_USER_BY_USERNAME_$Q = "FROM UserMaster "
			+ " WHERE deleteFlag=0 AND userName=:" + FIND_USER_BY_USERNAME_$P1;

}
