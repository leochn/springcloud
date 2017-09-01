package com.vnext.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vnext.core.Result;

@RestController
public class UserController {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${user.userServicePath}")
	private String userServicePath;

	@GetMapping("/consumer/sysUsers")
	public Result findById() {
		return this.restTemplate.getForObject(this.userServicePath, Result.class);
	}
	
/*	@GetMapping("/consumer/all")
	public Result getAll() {
		// SH-RAD02-V17.shwpg.com:springcloud-provide-user:8087
		return this.restTemplate.getForObject("http://springcloud-provide-user/api/sysUsers", Result.class);
	}*/

}
