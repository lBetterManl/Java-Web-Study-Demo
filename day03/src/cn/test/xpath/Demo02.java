package cn.test.xpath;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Demo02 {

	/**
	 * ����users.xml�ĵ��Ƿ��к��û���ƥ����û���������
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		String username = "aaa";
		String password = "123";
		
		//���xml�ĵ��Ƿ���ƥ����û���������
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/users.xml"));
		
		Node node = document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");	//д��ע��
		if (node==null) {
			System.out.println("�û�����������󣡣�");
		}else{
			System.out.println("��¼�ɹ���");
		}
	}

}
