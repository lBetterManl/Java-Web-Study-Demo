package com.yhc.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.yhc.entity.Department;
import com.yhc.service.DepartmentService;

public class DepartmentAction extends ActionSupport {

	@Autowired
	private DepartmentService departmentService;

	public String getAll() {

		List<Department> departments = departmentService.getAll();

		HttpServletRequest request = ServletActionContext.getRequest();

		
		request.setAttribute("departments", departments);

		System.out.println(departments);

		return SUCCESS;
	}
	
}
