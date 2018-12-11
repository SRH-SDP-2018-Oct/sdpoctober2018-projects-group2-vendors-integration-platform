package org.srh.vipapp.hbm.dao;

import java.util.List;

import org.hibernate.Session;
import org.srh.vipapp.hbm.dto.CustomerMaster;
import org.srh.vipapp.hbm.dto.ProductsMaster;

/**
 * HBM DAO to perform task related to {@link ProductsMaster} entity.  <br/>
 * Date: 03 Dec 2018
 * @author Anglita
 */
public interface ProductsMasterDao {

	/**
	 * Gets the {@link ProductsMaster} entity with the given 'productId'.
	 * @param productId {@link Integer}
	 * @return productsMaster {@link ProductsMaster}
	 */
	ProductsMaster findById(long productId);

	/**
	 * Gets the {@link ProductsMaster} entity with the given 'productId'.
	 * @param productId {@link Integer}
	 * @param session {@link Session}
	 * @return productsMaster {@link ProductsMaster}
	 */
	ProductsMaster findById(long productId, Session session);

	/**
	 * Gets the {@link ProductsMaster} entity with the given 'productName'.
	 * @param productName {@link String}
	 * @return productsMaster {@link ProductsMaster}
	 */
	List<ProductsMaster> findbyProductName(String productName);

	/**
	 * Returns all the {@link ProductsMaster} entities from persistence database
	 * @return productsMasterList {@link List<ProductsMaster>}
	 */
	List<ProductsMaster> getAllProducts();

	/**
	 * Returns all the {@link ProductsMaster} entities from persistence database with given 'productTypeId'
	 * @param isOnproductTypeIdOffer {@link Integer}
	 * @return productsMasterList {@link List<ProductsMaster>}
	 */
	List<ProductsMaster> getProductsByProductType(String productTypeName);


	/**
	 * Returns all the {@link ProductsMaster} entities on Offer from persistence database
	 * @return productsMasterList {@link List<ProductsMaster>}
	 */
	List<ProductsMaster> getAllProductsOnOffer();


	/**
	 * Returns all the {@link ProductsMaster} entities that are frequently brought by the customer
	 * @param customerMaster {@link CustomerMaster}
	 * @return productsMasterList {@link List<ProductsMaster>}
	 */
	List<ProductsMaster> frequentlyBoughtByCustomer(CustomerMaster customerMaster);


	

}
