package org.srh.vipapp.hbm.dao;

import java.util.List;

import org.srh.vipapp.hbm.dto.CartProduct;
import org.srh.vipapp.hbm.dto.CustomerCart;
import org.srh.vipapp.hbm.dto.ProductsMaster;

/**
 * HBM DAO to perform task related to {@link CartProduct} entity.  <br/>
 * Date: 10 Dec 2018
 * @author Vivek
 */
public interface CartProductDao {

	/**
	 * Returns all the products that are in the cart.
	 * @param customerCart {@link CustomerCart}
	 * @return listProductMaster {@link List<ProductsMaster>}
	 */
	List<ProductsMaster> getAllProductInCart(CustomerCart customerCart);
}
