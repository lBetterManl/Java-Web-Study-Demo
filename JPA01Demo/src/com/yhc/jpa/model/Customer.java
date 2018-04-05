package com.yhc.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月7日 下午9:49:20
 */

@Table(name="JPA_CUSTOMERS")
@Entity
public class Customer {

	private Integer id;
	private String lastName;
	private String email;
	private int age;
	
	private Date createdTime;
	private Date birth;
	
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="LAST_NAME")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	//工具方法，不需要映射为数据表的一列
	@Transient
	public String getInfo(){
		return "lastName: " + lastName + " , email: " + email;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", lastName=" + lastName + ", email=" + email + ", age=" + age
				+ ", createdTime=" + createdTime + ", birth=" + birth + "]";
	}
	
}
