package cn.test.xpath;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

public class Demo01 {
	
	//Ӧ��xpath��ȡxml�ĵ�����
	public static void main(String[] args) throws Exception {
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		String value = document.selectSingleNode("//����").getText();
		System.out.println(value);
	}

}
