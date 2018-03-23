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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName="/LoginFilter",urlPatterns={"/*"},initParams={@WebInitParam(name="path",value="loginServlet")})
public class LoginFilter implements Filter {
	
	// 不用过滤的servlet
	private String path;

    /**
     * Default constructor. 
     */
    public LoginFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("LoginFilter destroy......");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("LoginFilter doFilter......");
		System.out.println("path="+path);
		
		// place your code here
		if(request instanceof HttpServletRequest){
			Cookie[] cookies = ((HttpServletRequest) request).getCookies();
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName()+"="+cookie.getValue());
			}
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("LoginFilter init......");
		path = fConfig.getInitParameter("path");
	}

}
