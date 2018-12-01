package org.srh.vipapp.hbm.service;

import java.util.List;

import org.srh.vipapp.hbm.dao.CustomerMasterDao;
import org.srh.vipapp.hbm.dao.CustomerMasterDaoImpl;
import org.srh.vipapp.hbm.dto.CustomerMaster;

/**
 * Implementation class of HBM Service {@link CustomerMasterService}  <br/>
 * Date: 01 Dec 2018
 * @author Vivek
 */
public class CustomerMasterServiceImpl implements CustomerMasterService {

	private CustomerMasterDao customerMasterDao = new CustomerMasterDaoImpl();

	@Override
	public CustomerMaster findById(long customerId) {
		return customerMasterDao.findById(customerId);
	}

	@Override
	public List<CustomerMaster> getAllCustomers() {
		return customerMasterDao.getAllCustomers();
	}

	@Override
	public CustomerMaster findByUsername(String username) {
		return customerMasterDao.findByUsername(username);
	}

	@Override
	public List<CustomerMaster> findByName(String name) {
		return customerMasterDao.findByName(name);
	}

}
