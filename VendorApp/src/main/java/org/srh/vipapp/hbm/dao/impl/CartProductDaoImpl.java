package org.srh.vipapp.hbm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.CartProductDao;
import org.srh.vipapp.hbm.dto.CartProduct;
import org.srh.vipapp.hbm.dto.CustomerCart;
import org.srh.vipapp.hbm.dto.ProductsMaster;
import org.srh.vipapp.hbm.hql.CartProductQuery;

/**
 * Implementation class of HBM DAO {@link CartProductDao}  <br/>
 * Date: 10 Dec 2018
 * @author Vivek
 */
public class CartProductDaoImpl implements CartProductDao {

	@Override
	public List<ProductsMaster> getAllProductInCart(CustomerCart customerCart) {
		List<ProductsMaster> listProduct = new ArrayList<>();
		Session session = RootHB.getSessionFactory().openSession();
		try {
			@SuppressWarnings("unchecked")
			Query<CartProduct> query = session.createNamedQuery(CartProductQuery.FIND_PRODUCT_BY_CART_$N);
			query.setParameter(CartProductQuery.FIND_PRODUCT_BY_CART_$P1, customerCart);
			List<CartProduct> listCartProduct = query.getResultList();
			if(listCartProduct.isEmpty())
				return listProduct;
			int size = listCartProduct.size();
			for(int i=0; i<size; i++) {
				CartProduct cartProduct = listCartProduct.get(i);
				listProduct.add(cartProduct.getProductId());
			}
		}
		finally {
			RootHB.closeSession(session);
		}
		return listProduct;
	}


}
