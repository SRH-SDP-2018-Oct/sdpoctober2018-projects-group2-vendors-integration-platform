package org.srh.vipapp.hbm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.srh.util.AppLog;
import org.srh.util.StringUtil;
import org.srh.vipapp.hbm.RootHB;
import org.srh.vipapp.hbm.dao.ProductTypeDao;
import org.srh.vipapp.hbm.dao.VendorMasterDao;
import org.srh.vipapp.hbm.dto.ProductType;
import org.srh.vipapp.hbm.dto.VendorMaster;
import org.srh.vipapp.hbm.hql.ProductTypeQuery;

/**
 * Implementation class of HBM DAO {@link ProductTypeDao} <br/>
 * Date: 07 Dec 2018
 * @author Vivek
 */
public class ProductTypeDaoImpl implements ProductTypeDao {

	private VendorMasterDao vendorMasterDao = new VendorMasterDaoImpl();

	@Override
	public List<ProductType> getProductType(int vendorId, String productType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductType> getProductType(String vendorName, String productType) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<ProductType> getAllProductType(VendorMaster vendorMaster, Session session) {
		@SuppressWarnings("unchecked")
		Query<ProductType> query = session.createNamedQuery(ProductTypeQuery.GET_PRODUCT_TYPES_FOR_VENDOR_$N);
		query.setParameter(ProductTypeQuery.GET_PRODUCT_TYPES_FOR_VENDOR_$P1, vendorMaster);
		return query.getResultList();
	}

	@Override
	public List<ProductType> getAllProductType(int vendorId) {
		try ( Session session = RootHB.getSessionFactory().openSession(); ) {
			VendorMaster vendorMaster = vendorMasterDao.findById(vendorId, session);
			if(vendorMaster==null) {
				AppLog.log(ApiStructureDaoImpl.class, StringUtil.append("Vendor with id '", vendorId, "' not found"));
				return new ArrayList<>();
			}
			return getAllProductType(vendorMaster, session);
		}
	}

	@Override
	public List<ProductType> getAllProductType(String vendorName) {
		try ( Session session = RootHB.getSessionFactory().openSession(); ) {
			VendorMaster vendorMaster = vendorMasterDao.findByVendorName(vendorName, session);
			if(vendorMaster==null) {
				AppLog.log(ApiStructureDaoImpl.class, StringUtil.append("Vendor with name '", vendorName, "' not found"));
				return new ArrayList<>();
			}
			return getAllProductType(vendorMaster, session);
		}
	}

}
