/**
 * 
 */
package org.srh.vipapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.srh.bean.ServiceResp;
import org.srh.bean.ServiceRespArray;
import org.srh.constants.ErrorCode;
import org.srh.util.AppLog;
import org.srh.util.Common;
import org.srh.util.NumberUtil;
import org.srh.util.StringUtil;
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
	public ServiceResp getVendorById(String vendorId) {
		// Input Validation
		Integer vId = NumberUtil.getInteger(vendorId);
		if(vId==null) {
			String description = StringUtil.append("The customer id [", vendorId, "] is invalid integer.");
			return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
		}

		VendorMaster vendorMaster = vendorMasterDao.findById(vId);

		// Validate Data Existence
		if(vendorMaster==null) {
			String description =  StringUtil.append("No customer found with id [", vendorId, "].");
			return Common.buildServiceRespError(ErrorCode.NOT_FOUND, description);
		}

		// Data Exist, Return Success
		return Common.buildServiceResp(vendorMaster);
	}


	@Override
	public ServiceResp getVendorByVendorName(String vendorUsername) {
		// Input Validation
		if(Common.nullOrEmptyTrim(vendorUsername)) {
			String description = "Username not defined.";
			return Common.buildServiceRespError(ErrorCode.INVALID_INPUT, description);
		}

		VendorMaster vendorMaster = vendorMasterDao.findByVendorName(vendorUsername);

		// Validate Data Existence
		if(vendorMaster==null) {
			String err = StringUtil.append("Invalid username [", vendorUsername, "].");
			AppLog.log(CustomerServiceImpl.class, err);
			return Common.buildServiceRespError(ErrorCode.NOT_FOUND, err);
		}

		// Data Exist, Return Success
		return Common.buildServiceResp(vendorMaster);
	}


	@Override
	public ServiceRespArray getAllVendors() {

		List<VendorMaster> vendorMasterList = vendorMasterDao.getAllVendors();

		// Validate Data Existence
		if(vendorMasterList==null || vendorMasterList.isEmpty()) {
			String description =  "No vendors found.";
			return Common.buildServiceRespArrayError(ErrorCode.NOT_FOUND, description);
		}
		// Data Exist, Return Success
		return Common.buildServiceRespArray(vendorMasterList);
	}

}
