package com.vnext.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vnext.core.Result;
import com.vnext.core.ResultGenerator;
import com.vnext.pojo.SysUser;

@RestController
public class UserController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/consumer/all")
	@HystrixCommand(fallbackMethod = "getAllFallback")
	public Result getAll() {
		// userServicePath: http://localhost:8087/api/sysUsers
		// SH-RAD02-V17.shwpg.com:springcloud-provide-user:8087
		System.out.println("hystrix......into..........");
		return this.restTemplate.getForObject("http://springcloud-provide-user/api/sysUsers", Result.class);
	}

	public Result getAllFallback() {
		SysUser sysUser = new SysUser();
		sysUser.setId("0L");
		sysUser.setLoginName("0L");
		return ResultGenerator.genSuccessResult(1, sysUser);
	}

}
