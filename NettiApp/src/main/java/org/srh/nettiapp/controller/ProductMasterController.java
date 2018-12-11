package org.srh.nettiapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.srh.bean.ServiceRespArray;
import org.srh.nettiapp.hbm.RootHB;
import org.srh.nettiapp.hbm.dto.ProductMaster;
import org.srh.nettiapp.hbm.hql.ProductMasterQuery;
import org.srh.nettiapp.service.BranchService;
import org.srh.nettiapp.service.ProductService;
import org.srh.util.HttpUtil;

public class ProductMasterController {
		
		private ProductService productService;

		@RequestMapping(path = "/{products}", method = RequestMethod.GET)
		public String getAllProducts(HttpServletResponse resp) {
			ServiceRespArray serviceRespArray = productService.getAllProducts();
		return HttpUtil.buildResponseArray(resp, serviceRespArray).toString();
		}
}
