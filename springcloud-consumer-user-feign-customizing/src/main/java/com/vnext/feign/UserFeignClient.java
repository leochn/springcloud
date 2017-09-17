package com.vnext.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import com.vnext.config.UserFeignClientConfig;
import com.vnext.core.Result;

import feign.Param;
import feign.RequestLine;

@FeignClient(name="springcloud-provide-user",configuration = UserFeignClientConfig.class)
public interface UserFeignClient {
	//@GetMapping("/consumer/sysUsers")
	// 两个坑：1. @GetMapping不支持   2. @PathVariable得设置value
	//@RequestMapping(method = RequestMethod.GET, value = "/api/sysUsers")
	@RequestLine("GET /api/sysUser/{id}")
	public Result findById(@Param("id") String id);
}
