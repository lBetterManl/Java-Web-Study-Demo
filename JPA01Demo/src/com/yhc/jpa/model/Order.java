package com.yhc.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月8日 上午11:39:03
 */
@Table(name="JPA_ORDERS")
@Entity
public class Order {
	
	private Integer id;
	private String orderName;
	private Customer customer;
	
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="ORDER_NAME")
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	
	//映射单向n-1 的关联关系
	//使用@ManyToOne 来映射单向多对一的关联关系
	//使用@JoinColumn来映射外键
	//可以使用@ManyToOne 的fetch 来修改关联属性的加载策略
	@JoinColumn(name="CUSTOMER_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
