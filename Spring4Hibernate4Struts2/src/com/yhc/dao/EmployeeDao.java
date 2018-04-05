package com.yhc.dao;

import java.util.List;

import com.yhc.entity.Employee;

public interface EmployeeDao {

	public void delete(Integer id);
	
	public List<Employee> getAll();
	
	public void saveOrUpdate(Employee employee);
	
	public Employee getEmployeeByLastName(String lastName);
	
	public Employee get(Integer id);
}
