/**
 * 
 */
package org.srh.vipapp.service.impl;

import org.springframework.stereotype.Service;
import org.srh.util.NumberUtil;
import org.srh.vipapp.hbm.dao.VendorMasterDao;
import org.srh.vipapp.hbm.dao.impl.VendorMasterDaoImpl;
import org.srh.vipapp.hbm.dto.VendorMaster;
import org.srh.vipapp.service.VendorService;

/**
 * Serivce Implementation of {@link VendorService}.  <br/>
 * Date: 30 Nov 2018
 * @author Maitreyee
 */

@Service
public class VendorServiceImpl implements VendorService {
	
	private VendorMasterDao vendorMasterDao = new VendorMasterDaoImpl();

	@Override
	public String getVendorById(String vendorId) {
		Integer vId = NumberUtil.getInteger(vendorId);
		if(vId==null)
			return "{}";
		VendorMaster vendorMaster = vendorMasterDao.findById(vId.intValue());
		return vendorMaster==null ? "{}": vendorMaster.toString();
	}

}
