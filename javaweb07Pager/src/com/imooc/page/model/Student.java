package com.imooc.page.model;

import java.io.Serializable;
import java.util.Map;

public class Student implements Serializable {

	private static final long serialVersionUID = -7476381137287496245L;
	
	private int id; //ѧ����¼id
	
	private String stuName;//ѧ������
	
	private int age; //ѧ������
	
	private int gender; //ѧ���Ա�
	
	private String address;//ѧ��סַ
	
	public Student() {
		super();
	}

	public Student(int id, String stuName, int age, int gender, String address) {
		super();
		this.id = id;
		this.stuName = stuName;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	
	public Student(Map<String, Object> map){
		this.id = (Integer)map.get("id");
		this.stuName = (String)map.get("stu_name");
		this.age = (Integer)map.get("age");
		this.gender = (Integer)map.get("gender");
		this.address = (String)map.get("address");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", stuName=" + stuName + ", age=" + age
				+ ", gender=" + gender + ", address=" + address + "]";
	}
	
}
