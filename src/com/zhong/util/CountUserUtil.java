package com.zhong.util;
/**
 * 统计在线用户人数工具
 * @author admin
 *
 */
public class CountUserUtil {
	
	private static Long currentUserNumber = 0L;
	
	private CountUserUtil(){
		
	}
	
	public static synchronized void add(){
		currentUserNumber+=1;
	}
	public static Long get(){
		return currentUserNumber;
	}
}
