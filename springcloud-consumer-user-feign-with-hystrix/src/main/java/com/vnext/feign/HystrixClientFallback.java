package com.vnext.feign;

import org.springframework.stereotype.Component;

import com.vnext.core.Result;
import com.vnext.core.ResultGenerator;
import com.vnext.pojo.SysUser;

@Component
public class HystrixClientFallback implements UserFeignClient {

	@Override
	public Result findAll() {
		System.out.println("hystrixClientFallback.....................");
		SysUser sysUser = new SysUser();
		sysUser.setId("0L");
		sysUser.setLoginName("0L");
		return ResultGenerator.genSuccessResult(1, sysUser);
	} 
  
}
