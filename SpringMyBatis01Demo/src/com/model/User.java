package com.model;

public class User {
	private int id;
	private String username;
	private String age;
	
	public User() {
		super();
	}
	
	public User(int id, String username, String age) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
}
