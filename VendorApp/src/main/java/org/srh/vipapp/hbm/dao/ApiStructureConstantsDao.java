package org.srh.vipapp.hbm.dao;

import java.util.List;

import org.srh.vipapp.hbm.dto.ApiStructureConstants;

/**
 * HBM DAO to perform task related to {@link ApiStructureConstants} entity.  <br/>
 * Date: 05 Nov 2018
 * @author Maitreyee
 */
public interface ApiStructureConstantsDao {

	/**
	 * Returns all the {@link ApiStructureConstants} entities from persistence database
	 * @return apiStructureConstantsList {@link List<ApiStructureConstants>}
	 */
	public List<ApiStructureConstants> getAllApiStructConstants();

}
