package com.yhc.service;

import java.util.List;

import com.yhc.entity.Employee;

public interface EmployeeService {

	public boolean lastNameIsValid(String lastName);
	
	public void saveOrUpdate(Employee employee);
	
	public void delete(Integer id);
	
	public List<Employee> getAll();
	
	public Employee get(Integer id);
}
