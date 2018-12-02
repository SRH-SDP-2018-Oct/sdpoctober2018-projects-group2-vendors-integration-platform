package org.srh.vipapp.hbm.hql;

public final class CustomerMasterQuery {

	private CustomerMasterQuery() { }

	public static final String GET_ALL_CUSTOMERS_$N = "GET_ALL_CUSTOMERS";
	public static final String GET_ALL_CUSTOMERS_$Q = "FROM CustomerMaster "
			+ " WHERE deleteFlag=0";

	public static final String FIND_CUSTOMER_BY_USERNAME_$P1 = "userName";
	public static final String FIND_CUSTOMER_BY_USERNAME_$N = "FIND_CUSTOMER_BY_USERNAME";
	public static final String FIND_CUSTOMER_BY_USERNAME_$Q = "FROM CustomerMaster "
			+ " WHERE deleteFlag=0 AND userName=:"+FIND_CUSTOMER_BY_USERNAME_$P1;

	public static final String FIND_CUSTOMERS_BY_NAME_$P1 = "firstName";
	public static final String FIND_CUSTOMERS_BY_NAME_$P2 = "lastName";
	public static final String FIND_CUSTOMERS_BY_NAME_$N = "FIND_CUSTOMER_BY_NAME";
	public static final String FIND_CUSTOMERS_BY_NAME_$Q = "FROM CustomerMaster "
			+ " WHERE firstName LIKE :"+FIND_CUSTOMERS_BY_NAME_$P1
					+ " OR lastName LIKE :"+FIND_CUSTOMERS_BY_NAME_$P2;
}
