package org.srh.constants;

import org.srh.vipapp.hbm.dao.UserMasterDao;

public final class ValueConstants {

	private ValueConstants() { }

	// USER
	public static final String USER_ROOT = UserMasterDao.ROOT_USER;;
	public static final String USER_SYSTEM = UserMasterDao.SYSTEM_USER;

	public static final String PRODUCT_FILTER_LOCATION = "location";
	public static final String PRODUCT_FILTER_PRICE = "price";

}
