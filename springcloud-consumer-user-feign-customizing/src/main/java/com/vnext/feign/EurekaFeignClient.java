package com.vnext.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import feign.Param;
import feign.RequestLine;

@FeignClient(name = "xxxx", url = "http://localhost:9001/")
public interface EurekaFeignClient {
	//@RequestMapping(value = "/eureka/apps/{serviceName}")
	//public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
	@RequestLine("GET /eureka/apps/{serviceName}")
	public String findServiceInfoFromEurekaByServiceName(@Param("serviceName") String serviceName);
}
