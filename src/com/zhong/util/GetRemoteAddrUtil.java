package com.zhong.util;

import javax.servlet.http.HttpServletRequest;
/**
 * 获得客户端ip地址
 * @author admin
 *
 */
public class GetRemoteAddrUtil {

	private GetRemoteAddrUtil() {

	}
	
	/**
	 * 获得客户端ip地址
	 * @param request
	 * @return
	 */
	public static String getRemoteAddr(HttpServletRequest request) {
		/*
		 * 逻辑：
		 * 		如果XFF不为空，拿XFF的左边第一个
            	如果XFF为空，拿XRI
            	如果XRI为空，只能拿request.getRemoteAddr()，也就是只能拿到最直接发给他的机器ip了，
		 */
		if (null == request) {
			throw new RuntimeException("request is null");
		}
		String ip = request.getHeader("X-Forwarded-For");
		
		if (null !=ip && !"".equals(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		if (ip !=null && !"".equals(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			return ip;
		}
		return request.getRemoteAddr();
	}
}
