package com.yhc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.yhc.dao.BaseDao;
import com.yhc.dao.EmployeeDao;
import com.yhc.entity.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {

	@Override
	public void delete(Integer id) {
		String hql = "DELETE FROM Employee e WHERE e.id = ?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAll() {
		String hql = "FROM Employee e LEFT OUTER JOIN FETCH e.department";
		return getSession().createQuery(hql).list();
	}

	@Override
	public void saveOrUpdate(Employee employee) {
		getSession().saveOrUpdate(employee);

	}

	@Override
	public Employee getEmployeeByLastName(String lastName) {
		String hql = "FROM Employee e WHERE e.lastName = ?";
		Query query = getSession().createQuery(hql).setString(0, lastName);
		Employee employee = (Employee) query.uniqueResult();
		//System.out.println(employee.getDepartment().getClass().getName());
		return employee;
	}

	@Override
	public Employee get(Integer id) {
		return (Employee) getSession().get(Employee.class, id);
	}

}
