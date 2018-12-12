package org.srh.vipapp.hbm.dao;

import java.util.List;

import org.srh.vipapp.hbm.dto.CustomerFavouriteList;
import org.srh.vipapp.hbm.dto.ProductsMaster;

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
	CustomerFavouriteList findById(long id);

	/**
	 * Gets the {@link CustomerFavouriteList} entity with the given 'customerId'.
	 * @param customerId {@link Long}
	 * @return customerFavouriteList {@link CustomerFavouriteList}
	 */
	CustomerFavouriteList findByCustomerId(long customerId);


	/**
	 * Gets all the products from the latest Favourite list.
	 * @param customerId {@link String}
	 * @return listProductsMaster {@link List<ProductsMaster>}
	 */
	List<ProductsMaster> getFavouriteProducts(long customerId);
}
