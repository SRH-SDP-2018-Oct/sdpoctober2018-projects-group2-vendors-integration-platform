/**
 * 
 */
/**
 * @author YASHAS
 *
 */
package org.srh.nettiapp.controller;

package org.srh.nettiapp.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.srh.bean.ServiceRespArray;
import org.srh.util.HttpUtil;
import org.srh.nettiapp.service.BranchService;

/**
 * Rest Controller to serve the API/HTTP Call related to the Application Users.
 * Date: 03 Dec 2018
 * 
 * @author Shraddha
 */
@RestController
@RequestMapping("/user")
public class BranchController {

	@Autowired
	private BranchService branchService;

	@RequestMapping(path = "/{city}", method = RequestMethod.GET)
	public String getBranchesInCity(@PathVariable String city, HttpServletResponse resp) {
		ServiceRespArray serviceRespArray = branchService.getBranchesInCity(city);
		return HttpUtil.buildResponseArray(resp, serviceRespArray).toString();
	}
}