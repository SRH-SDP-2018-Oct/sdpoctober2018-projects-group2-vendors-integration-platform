package org.srh.vipapp.hbm.dao;

import java.util.List;

import org.srh.vipapp.hbm.dto.ProductType;

/**
 * HBM DAO to perform task related to {@link ProductType} entity.  <br/>
 * Date: 07 Dec 2018
 * @author Vivek
 */
public interface ProductTypeDao {

	/**
	 * Returns the {@link ProductType} entities from persistence database
	 * with given 'productType' and associated to the given vendor id.
	 * @param vendorId {@link Integer}
	 * @param productType {@link String}
	 * @return productTypeList {@link List<ProductType>}
	 */
	List<ProductType> getProductType(int vendorId, String productType);

	/**
	 * Returns all the {@link ProductType} entities from persistence database
	 * with given 'productType' and associated to the given vendor name.
	 * @param vendorName {@link String}
	 * @param productType {@link String}
	 * @return productsMasterList {@link List<VendorBranch>}
	 */
	List<ProductType> getProductType(String vendorName, String productType);

	/**
	 * Returns all the {@link ProductType} entities from persistence database
	 * associated to the given vendor id.
	 * @param vendorId {@link Integer}
	 * @param productType {@link String}
	 * @return productTypeList {@link List<ProductType>}
	 */
	List<ProductType> getAllProductType(int vendorId);

	/**
	 * Returns all the {@link ProductType} entities from persistence database
	 * associated to the given vendor name.
	 * @param vendorName {@link String}
	 * @return productsMasterList {@link List<VendorBranch>}
	 */
	List<ProductType> getAllProductType(String vendorName);

}
