package org.srh.vipapp.hbm.dao;

import org.srh.vipapp.hbm.dto.CustomerFavouriteList;

/**
 * HBM DAO to perform task related to {@link CustomerFavouriteList} entity.  <br/>
 * Date: 10 Dec 2018
 * @author Anglita
 */
public interface CustomerFavouriteListDao {
	/**
	 * Gets the {@link CustomerFavouriteList} entity with the given 'id'.
	 * @param id {@link Long}
	 * @return customerFavouriteList {@link CustomerFavouriteList}
	 */
	public CustomerFavouriteList findById(long id);
	
	/**
	 * Gets the {@link CustomerFavouriteList} entity with the given 'customerId'.
	 * @param customerId {@link Long}
	 * @return customerFavouriteList {@link CustomerFavouriteList}
	 */
	public CustomerFavouriteList findByCustomerId(long customerId);
	
	
}
