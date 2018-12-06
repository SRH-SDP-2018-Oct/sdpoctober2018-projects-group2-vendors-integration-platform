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
import org.srh.vipapp.service.ProductsService;


/**
 * Rest Controller to serve the API/HTTP Call related to the Products.
 * Date: 05 Dec 2018
 * @author Anglita
 */
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductsService productsService;
	
	@RequestMapping(path="/id/{productId}", method=RequestMethod.GET)
	public String getProductsById(@PathVariable String productId, HttpServletResponse resp) {
		ServiceResp serviceResp = productsService.getProductByProductId(productId);
		return HttpUtil.buildResponse(resp, serviceResp).toString();
	}
	
	@RequestMapping(path="/name/{productName}", method=RequestMethod.GET)
	public String getProductsByName(@PathVariable String productName, HttpServletResponse resp) {
		ServiceRespArray serviceRespArray = productsService.getProductsbyName(productName);
		return HttpUtil.buildResponseArray(resp, serviceRespArray).toString();
	}

	@RequestMapping(path="/all", method=RequestMethod.GET)
	public String getAllProducts(HttpServletResponse resp) {
		ServiceRespArray productServiceResponse = productsService.getAllProducts();
		return HttpUtil.buildResponseArray(resp, productServiceResponse).toString();
	}
	
	@RequestMapping(path="/productsOnOffers", method=RequestMethod.GET)
	public String getProductsOnOffers(HttpServletResponse resp) {
		ServiceRespArray serviceResp = productsService.getProductsOnOffers();
		return HttpUtil.buildResponseArray(resp, serviceResp).toString();
	}
	
	@RequestMapping(path="/productType/{productTypeName}", method=RequestMethod.GET)
	public String getProductsByProductType(@PathVariable String productTypeName,HttpServletResponse resp) {
		ServiceRespArray serviceResp = productsService.getProductsByProductType(productTypeName);
		return HttpUtil.buildResponseArray(resp, serviceResp).toString();
	}
	
}
