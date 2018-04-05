package com.yhc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yhc.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee getByLastName(String lastName);
	
}
