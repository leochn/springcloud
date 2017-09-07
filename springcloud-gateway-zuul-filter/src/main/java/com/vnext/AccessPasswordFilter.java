package com.vnext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessPasswordFilter extends ZuulFilter{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccessPasswordFilter.class);

	@Override
	public Object run() {
		// filter中的具体逻辑
		AccessPasswordFilter.LOGGER.info("执行zuulFilter的过滤器为:AccessPasswordFilter");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// 是否用过滤器
		RequestContext ctx = RequestContext.getCurrentContext();
		return (boolean) ctx.get("isSuccess");
		// 如果前一个过滤器的结果为true,则说明上一个过滤器成功了,需要进入当前的过滤;
		// 如果前一个过滤器结果为false,则说明上一个过滤器没有成功,则无需要进行下面的过滤动作了,直接跳过后面的所有过滤器并返回结果.
	}

	@Override
	public int filterOrder() {
		// filter执行的顺序,数字越大越靠后
		return 1;
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
