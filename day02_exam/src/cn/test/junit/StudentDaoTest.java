package cn.test.junit;

import org.junit.Test;

import cn.test.bean.Student;
import cn.test.dao.StudentDao;
import cn.test.exception.StudentNotExistException;

public class StudentDaoTest {

	@Test
	public void testAdd() {
		
		StudentDao dao = new StudentDao();
		Student s= new Student();
		s.setExamid("e33");
		s.setGrade(99);
		s.setIdcard("i33");
		s.setLocation("天门");
		s.setName("男神");
		dao.add(s);
	}
	
	
	@Test
	public void testFind(){
		
		StudentDao dao = new StudentDao();
		dao.find("123456");
	} 
	
	@Test
	public void testDelete() throws StudentNotExistException{
		
		StudentDao dao = new StudentDao();
		dao.delete("男神");
	}
}
