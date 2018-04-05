package cn.test.xpath;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Demo02 {

	/**
	 * 查找users.xml文档是否有和用户相匹配的用户名和密码
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		String username = "aaa";
		String password = "123";
		
		//检测xml文档是否有匹配的用户名和密码
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/users.xml"));
		
		Node node = document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");	//写法注意
		if (node==null) {
			System.out.println("用户名或密码错误！！");
		}else{
			System.out.println("登录成功！");
		}
	}

}
