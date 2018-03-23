package com.zhong.bean;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Integer age;
	private String remark;
	
	public User() {
		super();
	}
	public User(String name, Integer age, String remark) {
		super();
		this.name = name;
		this.age = age;
		this.remark = remark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", remark=" + remark + "]";
	}
	
	public String  toJsonString(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("{");
		
		sb.append("\"name:");
		sb.append("\"：");
		sb.append("\"");
		sb.append(this.getName());
		sb.append("\",");
		
		sb.append("\"age");
		sb.append("\"：");
		sb.append("");
		sb.append(this.getAge());
		sb.append(",");
		
		
		sb.append("\"remark:");
		sb.append("\"：");
		sb.append("\"");
		sb.append(this.getRemark());
		sb.append("\"");
		
		sb.append("}");
		
		return sb.toString();
	}
	
	
	
}
