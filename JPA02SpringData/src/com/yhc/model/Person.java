package com.yhc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月8日 下午2:14:22
 */

@Table(name="JPA_PERSONS")
@Entity
public class Person {

	private Integer id;
	private String lastName;
	private String email;
	private Date birth;
	
	private Address address;
	
	public Person() {
		super();
	}
	
	public Person(Integer id, String lastName, String email, Date birth, Address address) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.birth = birth;
		this.address = address;
	}
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	@Temporal(TemporalType.DATE)
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@JoinColumn(name="ADDRESS_ID")
	@ManyToOne
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", lastName=" + lastName + ", email=" + email + ", birth="
				+ birth + ", address=" + address + "]";
	}

}
