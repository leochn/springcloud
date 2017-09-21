package com.vnext.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.vnext.core.Result;
import com.vnext.feign.UserFeignClient;

@RestController
public class UserController {
	
	@Autowired
	private UserFeignClient userFeignClient;

	//@GetMapping("/api/sysUsers")
	@RequestMapping(method = RequestMethod.GET, value = "/api/sysUsers")
	public Result findAll() {
		//return this.restTemplate.getForObject(this.userServicePath, Result.class);
		System.out.println("springcloud-consumer-user-feign-with-hystrix---findAll");
		return this.userFeignClient.findAll();
	}

}
