package com.zhong.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhong.bean.User;

/**
 * Servlet implementation class ServletJson
 */
@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User("name",11,"remark");
		// 下面两行代码设置 response编码,内容类型为json
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8"); 
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("requestURI:"+request.getRequestURI());
		System.out.println("requestURL:"+request.getRequestURL());
		System.out.println("contextPath:"+request.getContextPath());
		System.out.println("queryString:"+request.getQueryString());
		
		System.out.println("protocol:"+request.getProtocol());
		System.out.println("serverName:"+request.getServerName());
		System.out.println("port:"+request.getServerPort());
		
		System.out.println("method:"+request.getMethod());
		System.out.println("contentType:"+request.getContentType());
		
		
		System.out.println(""+request.getRemoteHost());
		System.out.println(""+request.getRemoteAddr());
		System.out.println(""+request.getLocalName());
		System.out.println(""+request.getLocalAddr());
		
		System.out.println(user.toJsonString());
		response.getWriter().println(user.toJsonString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
