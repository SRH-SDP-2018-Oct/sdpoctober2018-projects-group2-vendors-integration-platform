package org.srh.vipapp.hbm.service.impl;

import java.util.List;

import org.srh.vipapp.hbm.dao.UserMasterDao;
import org.srh.vipapp.hbm.dao.impl.UserMasterDaoImpl;
import org.srh.vipapp.hbm.dto.UserMaster;
import org.srh.vipapp.hbm.service.UserMasterService;


/**
 * Implementation class of HBM Service {@link UserMasterService}  <br/>
 * Date: 29 Nov 2018
 * @author Vivek
 */
public class UserMasterServiceImpl implements UserMasterService {

	private UserMasterDao userMasterDao = new UserMasterDaoImpl();


	@Override
	public UserMaster findById(int userId) {
		return userMasterDao.findById(userId);
	}


	@Override
	public List<UserMaster> getAllUsers() {
		return userMasterDao.getAllUsers();
	}


	@Override
	public UserMaster findByUsername(String username) {
		return userMasterDao.findByUsername(username);
	}

}
