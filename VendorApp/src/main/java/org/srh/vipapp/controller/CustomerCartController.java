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
import org.srh.vipapp.service.CustomerCartService;

/**
 * Rest Controller to serve the API/HTTP Call related to the Application Customer.
 * Date: 09 Dec 2018
 * @author Anglita
 */

@RestController
@RequestMapping("/cart")
public class CustomerCartController {
	
	@Autowired
	private CustomerCartService customerCartService;


	@RequestMapping(path="/id/{cartId}", method=RequestMethod.GET)
	public String getCustomerById(@PathVariable String cartId, HttpServletResponse resp) {
		ServiceResp customerCartServiceResp = customerCartService.getCartsByCartId(cartId);
		return HttpUtil.buildResponse(resp, customerCartServiceResp).toString();
	}


	@RequestMapping(path="/all", method=RequestMethod.GET)
	public String getAllProducts(HttpServletResponse resp) {
		ServiceRespArray customerCartServiceResp = customerCartService.getAllCarts();
		return HttpUtil.buildResponseArray(resp, customerCartServiceResp).toString();
	}
	
	@RequestMapping(path="/userId/{userId}", method=RequestMethod.GET)
	public String getProductsByName(@PathVariable String userId, HttpServletResponse resp) {
		ServiceRespArray customerCartServiceResp = customerCartService.getCartsByUserId(userId);
		return HttpUtil.buildResponseArray(resp, customerCartServiceResp).toString();
	}
	
	
}
