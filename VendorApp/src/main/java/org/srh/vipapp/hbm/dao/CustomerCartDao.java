package org.srh.vipapp.hbm.dao;

import java.util.List;
import org.srh.vipapp.hbm.dto.CustomerCart;

/**
 * HBM DAO to perform task related to {@link CustomerCart} entity.  <br/>
 * Date: 08 Dec 2018
 * @author Anglita
 */
public interface CustomerCartDao {

	/**
	 * Gets the {@link CustomerCart} entity with the given 'cartId'.
	 * @param cartId {@link Integer}
	 * @return customerCart {@link CustomerCart}
	 */
	public CustomerCart findByCartId(long cartId);


	/**
	 * Returns all the {@link CustomerCart} entities from persistence database
	 * @return customerCartList {@link List<CustomerCart>}
	 */
	public List<CustomerCart> getAllCarts();
	
	/**
	 * Returns all the {@link CustomerCart} entities with the given 'userId'.
	 * @param customerId {@link Long}
	 * @return customerCartList {@link CustomerCart}
	 */
	public List<CustomerCart> getCartByCustomerId(long customerId);

}
