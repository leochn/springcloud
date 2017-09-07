package com.vnext;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreZuulFilter extends ZuulFilter{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PreZuulFilter.class);

	@Override
	public Object run() {
		// filter中的具体逻辑
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String host = request.getRemoteHost();
		PreZuulFilter.LOGGER.info("请求的host:{}",host);
		PreZuulFilter.LOGGER.info("执行zuulFilter的过滤器为:PreZuulFilter");
		boolean flag = true;
		//boolean flag = false;
		if (flag) {
			ctx.setSendZuulResponse(true); // 对该请求,进行路由
			ctx.set("isSuccess",true);     // 设值,让下一个Filter 看到上一个Filter的状态
		}else { 
			ctx.setSendZuulResponse(false); // 过滤该请求,不对其进行路由
			ctx.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED); // 返回错误码
			ctx.setResponseBody("{\"result\":\"unauthorized!\"}"); // 返回错误码
			ctx.set("isSuccess", false);
		}
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
		return 0;
	}

	@Override
	public String filterType() {
		// filter的类型
		// pre：可以在请求被路由之前调用
		// route：在路由请求时候被调用
		// post：在route和error过滤器之后被调用
		// error：处理请求时发生错误时被调用
		return "pre";
	}

}
