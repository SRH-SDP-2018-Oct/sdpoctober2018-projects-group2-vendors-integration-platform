package org.srh.vipapp.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.srh.bean.ServiceResp;
import org.srh.util.HttpUtil;
import org.srh.vipapp.service.UserService;

/**
 * Rest Controller to serve the API/HTTP Call related to the Application Users.
 * Date: 30 Nov 2018
 * @author Vivek
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;


	@RequestMapping("/login")
	public String userLogin() {
		return "Success";
	}
	
	
	@RequestMapping(path="/id/{userId}", method=RequestMethod.GET)
	public String getUserById(@PathVariable String userId, HttpServletResponse resp) {
		ServiceResp serviceResp = userService.getUserById(userId);
		return HttpUtil.buildResponse(resp, serviceResp).toString();
	}
}
