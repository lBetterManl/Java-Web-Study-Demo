package service.impl;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import service.StudentsDao;
import entity.Students;

public class TestStudentsDaoImpl {
	//测试查询所有学生
	@Test
	public void testQueryAllStudents()
	{
		StudentsDao sdao = new StudentsDaoImpl();
		List<Students> list = sdao.queryAllStudents();
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
	}
	
	//测试生成最新sid，测试时将StudentsDaoImpl()中getNewSid()改为public
	/*@Test
	public void testGetNewSid()
	{
		StudentsDaoImpl sdao = new StudentsDaoImpl();
		System.out.println(sdao.getNewSid());
	}*/
	
	//测试添加学生资料
	@Test
	public void testAddStudents()
	{
		Students s = new Students();
		s.setSname("哈哈");
		s.setGender("男");
		s.setBirthday(new Date());
		s.setAddress("中国");
		StudentsDao sdao = new StudentsDaoImpl();
		Assert.assertEquals(true, sdao.addStudents(s));//判断是否为期望值true
	}
}
