package com.yhc.demo;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Demo2 {

	//XPath解析
	@SuppressWarnings("unchecked")
	@Test
	public void XPath() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));
		
		List<Node> list = document.selectNodes("//书名");
		
		for(Node node:list){
			System.out.println(node.getText());
		}
	}
}
