package org.srh.nettiapp.hbm.dao;

import java.util.List;

import org.srh.nettiapp.hbm.dto.ProductMaster;

/**
 * HBM DAO to perform task related to {@link ProductsMaster} entity. <br/>
 * Date: 05 Dec 2018
 * 
 * @author Shraddha
 */

public interface ProductMasterDao {

	/**
	 * Gets the {@link ProductsMaster} entity with the given 'productId'.
	 * 
	 * @param productId {@link Integer}
	 * @return productsMaster {@link ProductMaster}
	 */
	public ProductMaster findById(int productId);

	/**
	 * Gets the {@link ProductsMaster} entity with the given 'productName'.
	 * 
	 * @param productName {@link String}
	 * @return productsMaster {@link ProductMaster}
	 */
	public List<ProductMaster> findbyProductName(String productName);

	/**
	 * Returns all the {@link ProductsMaster} entities from persistence database
	 * 
	 * @return productsMasterList {@link List<ProductsMaster>}
	 */
	public List<ProductMaster> getAllProducts();

	/**
	 * Returns all the {@link ProductsMaster} entities from persistence database
	 * with given 'productTypeId'
	 * 
	 * @param isOnproductTypeIdOffer {@link Integer}
	 * @return productsMasterList {@link List<ProductsMaster>}
	 */
	public List<ProductMaster> getProductsByProductType(int productTypeId);

}
