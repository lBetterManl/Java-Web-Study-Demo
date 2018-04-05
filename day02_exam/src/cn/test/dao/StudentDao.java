package cn.test.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.test.bean.Student;
import cn.test.exception.StudentNotExistException;
import cn.test.utils.XmlUtils;

public class StudentDao {

	public void add(Student s) {

		try {
			Document document = XmlUtils.getDocument();

			// 创建出封装学生信息的标签
			Element student_tag = document.createElement("student");
			student_tag.setAttribute("idcard", s.getIdcard());
			student_tag.setAttribute("examid", s.getExamid());

			// 创建用于封装学生姓名 所在地 成绩的标签
			Element name = document.createElement("name");
			Element location = document.createElement("location");
			Element grade = document.createElement("grade");

			name.setTextContent(s.getName());
			location.setTextContent(s.getLocation());
			grade.setTextContent(s.getGrade() + ""); // 任意东西和字符串相加都是字符串

			student_tag.appendChild(name);
			student_tag.appendChild(location);
			student_tag.appendChild(grade);

			// 把封装了信息学生标签，挂到文档上
			document.getElementsByTagName("exam").item(0)
					.appendChild(student_tag);

			// 更新内存
			XmlUtils.write2Xml(document);

		} catch (Exception e) {
			throw new RuntimeException(e);
			// unchecked exception(运行时异常)
		} // checked exception(编译时异常)

	}

	public Student find(String examid) {

		try {
			Document document = XmlUtils.getDocument();
			NodeList list = document.getElementsByTagName("student");

			for (int i = 0; i < list.getLength(); i++) {
				Element student_tag = (Element) list.item(i);
				if (student_tag.getAttribute("examid").equals(examid)) {
					// 找到了与examid相匹配的学生,new出一个student对象封装学生的信息返回
					Student s = new Student();
					s.setExamid(examid);
					s.setIdcard(student_tag.getAttribute("idcard"));
					s.setName(student_tag.getElementsByTagName("name").item(0)
							.getTextContent());
					s.setLocation(student_tag.getElementsByTagName("location")
							.item(0).getTextContent());
					Node p = student_tag.getElementsByTagName("grade").item(0);
						String str = p.getTextContent();
						double grade = Double.parseDouble(str);
						s.setGrade(grade);
						p=null;	//用完后赋空值
						return s;
						
				}
			}
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void delete(String name) throws StudentNotExistException {

		try {
			Document document = XmlUtils.getDocument();

			NodeList list = document.getElementsByTagName("name");
			for (int i = 0; i < list.getLength(); i++) {
				if (list.item(i).getTextContent().equals(name)) {
					list.item(i).getParentNode().getParentNode()
							.removeChild(list.item(i).getParentNode());
					XmlUtils.write2Xml(document);
					return;
				}
			}

			// 防止找不到，新建编译时异常
			throw new StudentNotExistException(name + "不存在！！");
		} catch (StudentNotExistException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
