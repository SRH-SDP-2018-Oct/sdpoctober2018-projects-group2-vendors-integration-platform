/**
 * 
 */
package org.srh.vipapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
	public String getVendorById(@PathVariable String vendorId) {
		return vendorService.getVendorById(vendorId);
	}

}
