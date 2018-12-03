package org.srh.vipapp.service;

import javax.servlet.http.HttpServletResponse;

import org.srh.bean.ServiceResp;

/**
 * Service Interface to perform the task related to Application Users.  <br/>
 * Date: 30 Nov 2018
 * @author Vivek
 */
public interface UserService {

	/**
	 * Returns user data of the given userId.
	 * @param userId {@link String}
	 * @return serviceResp {@link ServiceResp}
	 */
	ServiceResp getUserById(String userId);

}
