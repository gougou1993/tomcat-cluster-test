package com.zhong.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyServletEventListener
 *
 Servlet的监听器Listener，它是实现了javax.servlet.ServletContextListener 
 	接口的服务器端程序，它也是随web应用的启动而启动，只初始化一次，
 	随web应用的停止而销毁。主要作用是： 做一些初始化的内容添加工作、
 *设置一些基本的内容、比如一些参数或者是一些固定的对象等等。
 *下面利用监听器对数据库连接池DataSource的初始化演示它的使用：
 */
@WebListener
public class MyServletContextListener implements ServletContextListener, ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public MyServletContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
    	System.out.println("初始化");
    	// 通过这个事件可以获取整个应用的空间  
        // 在整个web应用下面启动的时候做一些初始化的内容添加工作  
        ServletContext sc = event.getServletContext();  
        
        // 设置一些基本的内容；比如一些参数或者是一些固定的对象 
        sc.setAttribute("initAttributeKey", "initAttributeValue");
        // TODO Auto-generated method stub
    }
	
}
