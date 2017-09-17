package com.vnext.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vnext.core.Result;

@RestController
public class UserController {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("/consumer/sysUsers")
	public Result findById() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("springcloud-provide-user");
		System.out.println("findById===" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":"
				+ serviceInstance.getPort());
		return this.restTemplate.getForObject("http://springcloud-provide-user/api/sysUsers", Result.class);
	}

	@GetMapping("/consumer/all")
	public Result getAll() {
		// userServicePath: http://localhost:8087/api/sysUsers
		// SH-RAD02-V17.shwpg.com:springcloud-provide-user:8087
		return this.restTemplate.getForObject("http://springcloud-provide-user/api/sysUsers", Result.class);
	}

	@GetMapping("/test")
	public String test() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("springcloud-provide-user");
		System.out.println("111" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":"
				+ serviceInstance.getPort());

		ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("springcloud-provide-users-v1");
		System.out.println("222" + ":" + serviceInstance2.getServiceId() + ":" + serviceInstance2.getHost() + ":"
				+ serviceInstance2.getPort());

		return "1";
	}

}
