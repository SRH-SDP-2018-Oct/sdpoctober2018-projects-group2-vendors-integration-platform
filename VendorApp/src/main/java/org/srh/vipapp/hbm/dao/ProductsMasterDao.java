package org.srh.vipapp.hbm.dao;

import java.util.List;
import org.srh.vipapp.hbm.dto.ProductsMaster;
import org.srh.vipapp.hbm.dto.UserMaster;

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
	public ProductsMaster findById(int productId);

	/**
	 * Gets the {@link ProductsMaster} entity with the given 'productName'.
	 * @param productName {@link String}
	 * @return productsMaster {@link ProductsMaster}
	 */
	public List<ProductsMaster> findbyProductName(String productName);

	/**
	 * Returns all the {@link ProductsMaster} entities from persistence database
	 * @return productsMasterList {@link List<ProductsMaster>}
	 */
	public List<ProductsMaster> getAllProducts();

	/**
	 * Returns all the {@link ProductsMaster} entities on Offer from persistence database
	 * @return productsMasterList {@link List<ProductsMaster>}
	 */
	public List<ProductsMaster> getAllProductsOnOffer();

	/**
	 * Returns all the {@link ProductsMaster} entities from persistence database with given 'productTypeId'
	 * @param isOnproductTypeIdOffer {@link Integer}
	 * @return productsMasterList {@link List<ProductsMaster>}
	 */
	public List<ProductsMaster> getProductsByProductType(String productTypeName);



}
