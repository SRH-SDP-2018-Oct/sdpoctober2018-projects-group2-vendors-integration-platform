/**
 * 
 */
package org.srh.vipapp.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.srh.bean.ServiceResp;
import org.srh.bean.ServiceRespArray;
import org.srh.util.HttpUtil;
import org.srh.vipapp.service.VendorService;

/**
 * @author Maitreyee
 * Date: 30 Nov 2018
 */

@RestController
@RequestMapping("/vendor")
public class VendorController {
	
	@Autowired
	private VendorService vendorService;


	@RequestMapping(path="/id/{vendorId}", method=RequestMethod.GET)
	public String getVendorById(@PathVariable String vendorId, HttpServletResponse resp) {
		ServiceResp serviceResp = vendorService.getVendorById(vendorId);
		return HttpUtil.buildResponse(resp, serviceResp).toString();
	}


	@RequestMapping(path="/name/{vendorName}", method=RequestMethod.GET)
	public String getVendorByUsername(@PathVariable String vendorName, HttpServletResponse resp) {
		ServiceResp serviceResp = vendorService.getVendorByVendorName(vendorName);
		return HttpUtil.buildResponse(resp, serviceResp).toString();
	}


	@RequestMapping(path="/all", method=RequestMethod.GET)
	public String getAllVendors(HttpServletResponse resp) {
		ServiceRespArray serviceResp = vendorService.getAllVendors();
		return HttpUtil.buildResponseArray(resp, serviceResp).toString();
	}

}
