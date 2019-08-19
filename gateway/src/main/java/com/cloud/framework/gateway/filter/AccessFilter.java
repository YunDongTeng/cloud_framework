package com.cloud.framework.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;


public class AccessFilter extends ZuulFilter {
    @Override
    public ZuulFilterResult runFilter() {
        return super.runFilter();
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        System.out.println("info:" + request.getMethod() + ",uri:" + request.getRequestURI());


        return null;
    }
}
