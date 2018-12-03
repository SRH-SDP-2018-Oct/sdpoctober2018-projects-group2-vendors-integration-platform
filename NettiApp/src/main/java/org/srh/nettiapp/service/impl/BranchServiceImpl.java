package org.srh.nettiapp.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.srh.constants.ErrorCode;
import org.srh.nettiapp.hbm.dao.BranchMasterDao;
import org.srh.nettiapp.hbm.dao.impl.BranchMasterDaoImpl;
import org.srh.nettiapp.hbm.dto.BranchMaster;
import org.srh.nettiapp.service.BranchService;
import org.srh.util.Common;
import org.srh.util.HttpUtil;
import org.srh.util.StringUtil;

/**
 * Serivce Implementation of {@link BranchService}.  <br/>
 * Date: 03 Dec 2018
 * @author Vivek
 */
@Service
public class BranchServiceImpl implements BranchService {

	private BranchMasterDao branchMasterDao = new BranchMasterDaoImpl();


	@Override
	public JSONObject getBranchesInCity(HttpServletResponse resp, String city) {
		//
		if(Common.nullOrEmptyTrim(city)) {
			String description = "The city cannot be blank.";
			return HttpUtil.errorResponse(resp, ErrorCode.INVALID_INPUT, description);
		}

		List<BranchMaster> branchMasterList = branchMasterDao.getBranchesInCity(city);
		//
		if(branchMasterList==null || branchMasterList.isEmpty()) {
			String description =  StringUtil.append("No branches found within city [", city, "].");
			return HttpUtil.errorResponse(resp, ErrorCode.NOT_FOUND, description);
		}
		// 
		return HttpUtil.successResponseArray(branchMasterList);
	}

}
