package org.srh.vipapp.activity;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.srh.bean.ServiceResp;
import org.srh.constants.ErrorCode;
import org.srh.util.Common;
import org.srh.util.StringUtil;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.CustomerMasterDao;
import org.srh.vipapp.hbm.dao.ProductsMasterDao;
import org.srh.vipapp.hbm.dao.impl.CustomerMasterDaoImpl;
import org.srh.vipapp.hbm.dao.impl.ProductsMasterDaoImpl;
import org.srh.vipapp.hbm.dto.CartProduct;
import org.srh.vipapp.hbm.dto.CustomerCart;
import org.srh.vipapp.hbm.dto.CustomerMaster;
import org.srh.vipapp.hbm.dto.ProductsMaster;
import org.srh.vipapp.hbm.dto.UserMaster;


/**
 * Date: 09 Dec 2018 
 * @author Vivek
 */
public class CartActivity {

	private CustomerMasterDao customerMasterDao = new CustomerMasterDaoImpl();
	private ProductsMasterDao productsMasterDao = new ProductsMasterDaoImpl();


	public ServiceResp saveCart(Long customerId, String displayName, Long productId, Integer productCount) {
		Session session = RootHB.getSessionFactory().openSession();

		// Cart Transaction
		Transaction transaction = session.beginTransaction();
		try {
			// 
			CustomerMaster customerMaster = customerMasterDao.findById(customerId, session);
			if(customerMaster==null) {
				RootHB.closeSession(session);
				String description = StringUtil.append("The customer id [", customerId, "] is invalid integer.");
				return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
			}

			// 
			UserMaster systemUser = RootHB.getSystemUser();

			// Create [CustomerCart] entity object to save it.
			CustomerCart customerCart = new CustomerCart();
			customerCart.setCustomerId(customerMaster);
			customerCart.setCreatedBy(systemUser);
			customerCart.setModifiedBy(systemUser);
			customerCart.setDisplayName(displayName);
			session.save(customerCart);

			BigDecimal totalPrice = customerCart.getTotalPrice();

			// Save Products in Cart
			ProductsMaster productsMaster = productsMasterDao.findById(productId, session);
			if(productsMaster==null) {
				String description = StringUtil.append("The product id [", productId, "] is invalid integer.");
				return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
			}
			saveCartProduct(session, customerCart, productsMaster, productCount, systemUser);
			totalPrice = totalPrice.add(productsMaster.getProductPrice());

			customerCart.setTotalPrice(totalPrice);
			session.update(customerCart);
			transaction.commit();
			return Common.buildServiceResp(customerCart);
		}
		catch(Exception ex) {
			transaction.rollback();
			String desc = ex.getMessage();
			return Common.buildServiceRespError(ErrorCode.EXCEPTION, desc);
		}
		finally {
			RootHB.closeSession(session);
		}
	}


	public ServiceResp saveCart(Long customerId, String displayName, List<Long> productList, List<Integer> productCountList) {
		Session session = RootHB.getSessionFactory().openSession();

		// Cart Transaction
		Transaction transaction = session.beginTransaction();
		try {
			// 
			CustomerMaster customerMaster = customerMasterDao.findById(customerId, session);
			if(customerMaster==null) {
				RootHB.closeSession(session);
				String description = StringUtil.append("The customer id [", customerId, "] is invalid integer.");
				return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
			}

			// 
			UserMaster systemUser = RootHB.getSystemUser();

			// Create [CustomerCart] entity object to save it.
			CustomerCart customerCart = new CustomerCart();
			customerCart.setCustomerId(customerMaster);
			customerCart.setCreatedBy(systemUser);
			customerCart.setModifiedBy(systemUser);
			customerCart.setDisplayName(displayName);
			session.save(customerCart);

			BigDecimal totalPrice = customerCart.getTotalPrice();

			int len = productList.size();
			for(int i=0; i<len; i++) {
				// Save Products in Cart
				Long productId = productList.get(i);
				Integer productCount = productCountList.get(i);
				ProductsMaster productsMaster = productsMasterDao.findById(productId, session);
				if(productsMaster==null) {
					String description = StringUtil.append("The product id [", productId, "] is invalid integer.");
					return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
				}
				saveCartProduct(session, customerCart, productsMaster, productCount, systemUser);
				totalPrice = totalPrice.add(productsMaster.getProductPrice());
			}

			customerCart.setTotalPrice(totalPrice);
			session.update(customerCart);
			transaction.commit();
			return Common.buildServiceResp(customerCart);
		}
		catch(Exception ex) {
			transaction.rollback();
			String desc = ex.getMessage();
			return Common.buildServiceRespError(ErrorCode.EXCEPTION, desc);
		}
		finally {
			RootHB.closeSession(session);
		}
	}


	private CartProduct saveCartProduct(Session session, CustomerCart cart,
			ProductsMaster productsMaster, Integer productCount, UserMaster systemUser) {
		CartProduct cartProduct = new CartProduct();
		cartProduct.setCartId(cart);
		cartProduct.setProductId(productsMaster);
		cartProduct.setProductCount(productCount);
		cartProduct.setCreatedBy(systemUser);
		cartProduct.setModifiedBy(systemUser);
		session.save(cartProduct);
		return cartProduct;
	}
}
