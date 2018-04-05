package cn.test.UI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import cn.test.bean.Student;
import cn.test.dao.StudentDao;
import cn.test.exception.StudentNotExistException;

public class Main {

	public static void main(String[] args) {
		try {
			System.out.println("添加学生(a)    删除学生(b)    查找学生(c)");
			System.out.print("请输入操作类型：");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String type = br.readLine();
			
			if ("a".equals(type)) {
				
				System.out.println("请输入学生姓名：");
				String name = br.readLine();
				
				System.out.println("请输入学生准考证号：");
				String examid = br.readLine();
				
				System.out.println("请输入学生身份证号：");
				String idcard = br.readLine();
				
				System.out.println("请输入学生所在地：");
				String location = br.readLine();
				
				System.out.println("请输入学生成绩：");
				String grade = br.readLine();
				
				Student s = new Student();
				s.setExamid(examid);
				s.setGrade(Double.parseDouble(grade));
				s.setIdcard(idcard);
				s.setLocation(location);
				s.setName(name);
				
				StudentDao dao = new StudentDao();
				dao.add(s);
				
				System.out.println("添加成功！");
				
			} else if("b".equals(type)) {

				System.out.println("请输入要删除学生的姓名：");
				String name = br.readLine();
				
				try {
					StudentDao dao = new StudentDao();
					dao.delete(name);
					System.out.println("删除成功！");
				} catch (StudentNotExistException e) {
					System.out.println("您要删除的学生不存在！！");
				}
				
			} else if("c".equals(type)) {
				
				System.out.println("请输入要要查找学生的准考证号：");
				String examid = br.readLine();
				
				StudentDao dao = new StudentDao();
				if (dao.find(examid)!=null) {
					System.out.println("找到！");
				}
				else{
					System.out.println("未找到！！");
				}

			}else{
				System.out.println("对不起，不支持此输入类型！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("对不起出错了！");
		}
		
	}

}
