package org.srh.vipapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.srh.vipapp.service.CustomerLoginRegistrationService;
import org.srh.vipapp.service.CustomerService;

/**
 * Rest Controller to serve the API/HTTP Call related to the Application Customer.
 * Date: 01 Dec 2018
 * @author Vivek
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerLoginRegistrationService customerLoginRegistrationService;


	@RequestMapping("/login")
	public String customerLogin(@RequestParam String username, @RequestParam String pwd, 
			HttpServletResponse resp, HttpServletRequest req) {
		return customerLoginRegistrationService.authenticate(req, resp, username, pwd).toString();
	}


	@RequestMapping(path="/id/{customerId}", method=RequestMethod.GET)
	public String getCustomerById(@PathVariable String customerId, HttpServletResponse resp) {
		return customerService.getCustomerById(resp, customerId).toString();
	}


	@RequestMapping(path="/name/{customerName}", method=RequestMethod.GET)
	public String getCustomerByName(@PathVariable String customerName, HttpServletResponse resp) {
		return customerService.getCustomersByName(resp, customerName).toString();
	}

}
