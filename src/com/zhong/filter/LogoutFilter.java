package com.zhong.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class LogoutFilter
 */
@WebFilter(
		description = "退出", 
		urlPatterns = { "/LogoutFilter" }, 
		initParams = { 
				@WebInitParam(name = "path", value = "LogoutServlet", description = "过滤地址")
		})
public class LogoutFilter implements Filter {

	private String path;
    /**
     * Default constructor. 
     */
    public LogoutFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("LogoutFilter destroy......");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("LogoutFilter doFilter......");
		// place your code here
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("LogoutFilter init......");
		// 设置初始化的参数值
		path = fConfig.getInitParameter("path");
	}

}
