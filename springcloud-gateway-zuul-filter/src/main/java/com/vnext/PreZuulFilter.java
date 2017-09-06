package com.vnext;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreZuulFilter extends ZuulFilter{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PreZuulFilter.class);

	@Override
	public Object run() {
		// filter中的具体逻辑
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		String host = request.getRemoteHost();
		PreZuulFilter.LOGGER.info("请求的host:{}",host);
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// 是否用过滤器
		return true;
	}

	@Override
	public int filterOrder() {
		// filter执行的顺序,数字越大越靠后
		return 1;
	}

	@Override
	public String filterType() {
		// filter的类型
		return "pre";
	}

}
