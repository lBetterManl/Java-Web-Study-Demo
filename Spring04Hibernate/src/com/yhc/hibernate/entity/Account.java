package com.yhc.hibernate.entity;
/**
 * Account 实体类
 * @author YHC
 *
 */
public class Account {

	private Integer id;
	private String username;
	private int balance;//余额

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
