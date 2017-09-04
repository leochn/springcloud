package com.vnext.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vnext.UserFeignClient;
import com.vnext.core.Result;

@RestController
public class UserController {
	
	@Autowired
	private UserFeignClient userFeignClient;

	@GetMapping("/api/sysUsers")
	//@RequestMapping(method = RequestMethod.GET, value = "/api/sysUsers")
	public Result findById() {
		//return this.restTemplate.getForObject(this.userServicePath, Result.class);
		return this.userFeignClient.findById();
	}

}
