package com.zhong.util;
/**
 * HTMLUtil
 * @author admin
 *
 */
public class HTMLUtil {
	
	public static String H5 = "<!DOCTYPE HTML>";
	public static String H4 = "<!DOCTYPE HTML>";
	/**
	 * 私有
	 */
	private HTMLUtil(){
		
	}
	/**
	 * 生成html
	 * @param obj
	 * @return
	 */
	public static String createHtml(Object obj,String docType){
		
		StringBuffer html = new StringBuffer();
		
		html.append(docType);
		
		html.append("<html>");
			html.append("<body>");
				html.append("<div>");
					
				html.append("</div>");
			html.append("</body>");
		html.append("<html>");
		
		return html.toString();
		
	}
}
