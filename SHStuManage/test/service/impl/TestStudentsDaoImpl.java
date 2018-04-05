package service.impl;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import service.StudentsDao;
import entity.Students;

public class TestStudentsDaoImpl {
	//���Բ�ѯ����ѧ��
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
	
	//������������sid������ʱ��StudentsDaoImpl()��getNewSid()��Ϊpublic
	/*@Test
	public void testGetNewSid()
	{
		StudentsDaoImpl sdao = new StudentsDaoImpl();
		System.out.println(sdao.getNewSid());
	}*/
	
	//�������ѧ������
	@Test
	public void testAddStudents()
	{
		Students s = new Students();
		s.setSname("����");
		s.setGender("��");
		s.setBirthday(new Date());
		s.setAddress("�й�");
		StudentsDao sdao = new StudentsDaoImpl();
		Assert.assertEquals(true, sdao.addStudents(s));//�ж��Ƿ�Ϊ����ֵtrue
	}
}
