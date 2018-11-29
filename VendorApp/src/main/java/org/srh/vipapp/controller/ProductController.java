package org.srh.vipapp.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vip")
public class ProductController {

	@RequestMapping(path="/products", method=RequestMethod.GET)
	public String getProduct() {

		JSONObject jsonObject;
		JSONArray jsonArray = new JSONArray();

		jsonObject = new JSONObject();
		jsonObject.put("Product_Name", "H-Milk 1.5");
		jsonObject.put("Product_Type", "Dairy");
		jsonObject.put("Product_Detail", "Milk with fat percentage of 1.5%");
		jsonObject.put("Product_Brand", "Gutes Land");
		jsonArray.put(jsonObject);
		
		jsonObject = new JSONObject();
		jsonObject.put("Product_Name", "Milch 1.5");
		jsonObject.put("Product_Type", "Dairy");
		jsonObject.put("Product_Detail", "Milk with fat percentage of 3.5%");
		jsonObject.put("Product_Brand", "Pemmy");
		jsonArray.put(jsonObject);

		return jsonArray.toString();
	}

}
