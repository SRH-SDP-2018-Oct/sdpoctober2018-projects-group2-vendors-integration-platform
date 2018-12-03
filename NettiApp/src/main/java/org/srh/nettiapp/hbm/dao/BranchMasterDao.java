package org.srh.nettiapp.hbm.dao;

import java.util.List;

import org.srh.nettiapp.hbm.dto.BranchMaster;


/**
 * HBM DAO to perform task related to {@link BranchMaster} entity.  <br/>
 * Date: 02 Dec 2018
 * @author Vivek
 */
public interface BranchMasterDao {

	/**
	 * Fetches the list of branches within the city.
	 * @param city {@link String}
	 * @return branchList {@link List<BranchMaster}
	 */
	List<BranchMaster> getBranchesInCity(String city);

}
