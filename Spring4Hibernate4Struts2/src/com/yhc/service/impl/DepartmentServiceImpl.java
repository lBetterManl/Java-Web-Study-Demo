package com.yhc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhc.dao.DepartmentDao;
import com.yhc.entity.Department;
import com.yhc.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	public List<Department> getAll() {
		
		return departmentDao.getAll();
	}

}
