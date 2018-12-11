package org.srh.aldoapp.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.srh.bean.ServiceRespArray;
import org.srh.aldoapp.service.ProductService;
import org.srh.util.HttpUtil;

public class ProductMasterController {
	
	private ProductService productService;

	@RequestMapping(path = "/{products}", method = RequestMethod.GET)
	public String getAllProducts(HttpServletResponse resp) {
		ServiceRespArray serviceRespArray = productService.getAllProducts();
	return HttpUtil.buildResponseArray(resp, serviceRespArray).toString();
	}
}
