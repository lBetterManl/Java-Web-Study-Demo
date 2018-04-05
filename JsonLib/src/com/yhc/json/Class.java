package com.yhc.json;

import java.util.Date;
import java.util.List;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月3日 下午4:39:23
 */
public class Class {
	
	private String name;
	private Date date;
	private List<Student> students;
	
	public Class() {
		super();
	}

	public Class(String name, Date date, List<Student> students) {
		super();
		this.name = name;
		this.date = date;
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Class [name=" + name + ", date=" + date + ", students=" + students + "]";
	}

}
