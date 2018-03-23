package com.zhong.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter(filterName="/LogFilter",urlPatterns={"/*"})
public class LogFilter implements Filter {
	
	private FilterConfig fConfig;
	
    /**
     * Default constructor. 
     */
    public LogFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		ServletContext context = this.fConfig.getServletContext();  
        //long before = System.currentTimeMillis();  
        System.out.println("before the log filter!");
        //context.log("开始过滤");  
        // 将请求转换成HttpServletRequest 请求  
        HttpServletRequest hreq = (HttpServletRequest) request;  
        // 记录日志  
        System.out.println("Log Filter已经截获到用户的请求的地址:"+hreq.getServletPath() );  
        //context.log("Filter已经截获到用户的请求的地址: " + hreq.getServletPath());  
        try {  
            // Filter 只是链式处理，请求依然转发到目的地址。  
            chain.doFilter(request, response);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        System.out.println("after the log filter!");
		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
	}

}
