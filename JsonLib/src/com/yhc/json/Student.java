package com.yhc.json;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月3日 下午4:36:34
 */
public class Student {
	
	private String username;
	private String sex;
	private int age;
	
	public Student() {
		super();
	}
	
	public Student(String username, String sex, int age) {
		super();
		this.username = username;
		this.sex = sex;
		this.age = age;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [username=" + username + ", sex=" + sex + ", age=" + age + "]";
	}	
	
}
