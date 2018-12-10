package org.srh.vipapp.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.srh.bean.ServiceResp;
import org.srh.bean.ServiceRespArray;
import org.srh.util.HttpUtil;
import org.srh.vipapp.service.CustomerFavouriteListService;

/**
 * Rest Controller to serve the API/HTTP Call related to the Application Customer's Favourite List.
 * Date: 10 Dec 2018
 * @author Anglita
 */

@RestController
@RequestMapping("/favouritelist")
public class CustomerFavouriteListController {

	@Autowired
	private CustomerFavouriteListService customerFavouriteListService;


	@RequestMapping(path="/id/{listId}", method=RequestMethod.GET)
	public String getFavouriteListById(@PathVariable String listId, HttpServletResponse resp) {
		ServiceResp customerFavouriteListServiceResp = customerFavouriteListService.getFavouriteListById(listId);
		return HttpUtil.buildResponse(resp, customerFavouriteListServiceResp).toString();
	}

	@RequestMapping(path="/customerId/{customerId}", method=RequestMethod.GET)
	public String getProductsByName(@PathVariable String customerId, HttpServletResponse resp) {
		ServiceResp customerFavouriteListServiceResp = customerFavouriteListService.getFavouriteListByCustomerId(customerId);
		return HttpUtil.buildResponse(resp, customerFavouriteListServiceResp).toString();
	}


	@RequestMapping(path="/add", method=RequestMethod.POST)
	public String add(@RequestBody String data, HttpServletResponse resp) {
		String customerId = "1";
		ServiceResp customerFavouriteListServiceResp = customerFavouriteListService.addProductToFavouriteList(data, customerId);
		return HttpUtil.buildResponse(resp, customerFavouriteListServiceResp).toString();
	}


	@RequestMapping(path="/addAll", method=RequestMethod.POST)
	public String addAll(@RequestBody String data, HttpServletResponse resp) {
		String customerId = "1";
		ServiceRespArray customerFavouriteListServiceResp = customerFavouriteListService.addProductsToFavouriteList(data, customerId);
		return HttpUtil.buildResponseArray(resp, customerFavouriteListServiceResp).toString();
	}

}
