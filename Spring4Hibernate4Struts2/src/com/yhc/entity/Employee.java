package com.yhc.entity;

/**
 * 多的一方
 * 
 * @author YHC
 *
 */
public class Employee {

	private Integer id;
	// 不能被修改
	private String lastName;

	// 单向 n-1 的关联关系
	private Department department;

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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee() {
		super();
	}

	public Employee(Integer id, String lastName, Department department) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", department=" + department + "]";
	}

}
