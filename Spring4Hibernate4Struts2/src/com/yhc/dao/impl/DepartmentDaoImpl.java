package com.yhc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yhc.dao.BaseDao;
import com.yhc.dao.DepartmentDao;
import com.yhc.entity.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDao implements DepartmentDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getAll() {
		String hql = "FROM Department";
		return getSession().createQuery(hql).list();
	}

}
