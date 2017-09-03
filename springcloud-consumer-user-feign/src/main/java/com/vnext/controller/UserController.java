package com.vnext.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
