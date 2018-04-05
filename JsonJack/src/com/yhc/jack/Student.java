package com.yhc.jack;

import java.util.Date;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月7日 下午8:53:33
 */
public class Student {
	
	private String stuname;
	private Date birthday;
	private Integer age;
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

}
