package cn.test.xpath;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

public class Demo01 {
	
	//应用xpath提取xml文档数据
	public static void main(String[] args) throws Exception {
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		String value = document.selectSingleNode("//作者").getText();
		System.out.println(value);
	}

}
