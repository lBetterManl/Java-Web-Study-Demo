package com.yhc.test;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年9月13日 上午11:45:01
 */
public class User {

	private String name;
	private Integer age;

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

	public User() {
		super();
	}

	public User(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

	public boolean equals(Object obj){
		if(!(obj instanceof User))return false;
		User u = (User)obj;
		return this.name.equals(u.getName());
	}
}
