package com.vnext.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vnext.core.Result;
import com.vnext.feign.EurekaFeignClient;
import com.vnext.feign.UserFeignClient;

@RestController
public class UserController {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	private EurekaFeignClient eurekaFeignClient;

	@GetMapping("/api/sysUser/{id}")
	//@RequestMapping(method = RequestMethod.GET, value = "/api/sysUsers")
	public Result findById(@PathVariable String id) {
		return this.userFeignClient.findById(id);
	}
	
	@GetMapping("/{serviceName}")
	public String findServiceInfoFromEurekaByServiceName(@PathVariable String serviceName) {
		return this.eurekaFeignClient.findServiceInfoFromEurekaByServiceName(serviceName);
	}

}
