package com.vnext;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vnext.core.Result;

@FeignClient("springcloud-provide-user")
public interface UserFeignClient {
	//@GetMapping("/consumer/sysUsers")
	// 两个坑：1. @GetMapping不支持   2. @PathVariable得设置value
	@RequestMapping(method = RequestMethod.GET, value = "/api/sysUsers")
	public Result findById();
}
