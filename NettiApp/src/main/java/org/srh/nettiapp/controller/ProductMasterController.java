package org.srh.nettiapp.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.srh.bean.ServiceRespArray;
import org.srh.nettiapp.service.ProductService;
import org.srh.util.HttpUtil;

@RestController
@RequestMapping("/products")
public class ProductMasterController {

	@Autowired
	private ProductService productService;

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public String getAllProducts(HttpServletResponse resp) {
		ServiceRespArray serviceRespArray = productService.getAllProducts();
		return HttpUtil.buildResponseArray(resp, serviceRespArray).toString();
	}

	@RequestMapping(path = "/all", method = RequestMethod.POST)
	public String getAllProductsPost(HttpServletResponse resp) {
		ServiceRespArray serviceRespArray = productService.getAllProducts();
		return HttpUtil.buildResponseArray(resp, serviceRespArray).toString();
	}
}
