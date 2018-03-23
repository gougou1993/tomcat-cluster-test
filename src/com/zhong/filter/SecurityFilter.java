package com.zhong.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhong.util.GetRemoteAddrUtil;

/**
 * Servlet Filter implementation class SecurityFilter
 */
@WebFilter(filterName="SecurityFilter",description = "安全过滤", urlPatterns = { "/*" }, initParams = {
		@WebInitParam(name = "allowIps", value = "192.168.1.101,180.100.254,127.0.0.1,0:0:0:0:0:0:0:1"),@WebInitParam(name="path",value="SecurityFilter")})
public class SecurityFilter implements Filter {

	private String path;
	
	private List<String> whitelist;

	/**
	 * Default constructor.
	 */
	public SecurityFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain filterchain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletrequest;
		HttpServletResponse response = (HttpServletResponse) servletresponse;
		
		String remoteAddr = request.getRemoteAddr();
		remoteAddr = GetRemoteAddrUtil.getRemoteAddr(request);
		System.out.println("remoteAddr:"+remoteAddr);
		
		if (isSecurityIp(remoteAddr)) {
			filterchain.doFilter(servletrequest, servletresponse);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print("<script>alert('客户端未授权，请联系管理员！');</script>");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		System.out.println("SecurityFilter init ......");
		
		String allowIps = fConfig.getInitParameter("allowIps");
		String filterName = fConfig.getFilterName();
		String path = fConfig.getInitParameter("path");
		
		System.out.println("path:"+path);
		
		whitelist = Arrays.asList(allowIps.split(","));
	}

	/**
	 * 判断当前IP是否是允许登录
	 * 
	 * @param remoteAddr
	 * @return
	 */
	public boolean isSecurityIp(String remoteAddr) {
		if (whitelist == null || whitelist.size() == 0)
			return true;
		for (String item : whitelist) {
			if (remoteAddr.startsWith(item))
				return true;
		}
		return false;
	}

}
