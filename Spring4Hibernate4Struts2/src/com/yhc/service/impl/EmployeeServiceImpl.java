package com.yhc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhc.dao.EmployeeDao;
import com.yhc.entity.Employee;
import com.yhc.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public boolean lastNameIsValid(String lastName) {
		return employeeDao.getEmployeeByLastName(lastName) == null;
	}

	@Override
	public void saveOrUpdate(Employee employee) {
		employeeDao.saveOrUpdate(employee);

	}

	@Override
	public void delete(Integer id) {
		employeeDao.delete(id);

	}

	@Override
	public List<Employee> getAll() {
		List<Employee> employees = employeeDao.getAll();
		return employees;
	}

	@Override
	public Employee get(Integer id) {
		return employeeDao.get(id);
	}

}
