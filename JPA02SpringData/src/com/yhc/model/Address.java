package com.yhc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月8日 下午3:43:38
 */

@Table(name="JPA_ADDRESSES")
@Entity
public class Address {

	private Integer id;
	private String province;
	private String city;
	
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", province=" + province + ", city=" + city + "]";
	}
}
