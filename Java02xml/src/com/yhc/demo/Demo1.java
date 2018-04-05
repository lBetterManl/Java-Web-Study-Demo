package com.yhc.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class Demo1 {

	@Test
	public void read() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element root = document.getRootElement();
		Element book = (Element) root.elements("书").get(0);
		String bookname = book.element("书名").getText();
		System.out.println("第一本书的书名是： " + bookname);
	}

	@Test
	public void read2() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element root = document.getRootElement();
		Element book = (Element) root.elements("书").get(1);
		// String name = book.element("书名").attribute("name").getValue();
		String name = book.element("书名").attributeValue("name");
		System.out.println("第二本书的书名的name属性是： " + name);
	}

	// 第一本书删除原来的售价添加一个新的售价
	@SuppressWarnings("unchecked")
	@Test
	public void add() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element root = document.getRootElement();
		Element book = root.element("书");
		List<Element> prices = book.elements("售价");

		for (Iterator<Element> it = prices.iterator(); it.hasNext();) {
			book.remove(it.next());
		}
		book.addElement("售价").setText("148元");

		// 格式化输出器
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");

		// XMLWriter writer = new XMLWriter(new OutputStreamWriter(new
		// FileOutputStream("src/book.xml"), "UTF-8"),format);
		// XMLWriter writer = new XMLWriter(new
		// FileOutputStream("src/book.xml"), format);
		XMLWriter writer = new XMLWriter(new FileWriter("src/book.xml"), format);

		writer.write(document);
		writer.close();
	}

	// 第一本书添加在制定位置添加新的售价
	@SuppressWarnings("unchecked")
	@Test
	public void add2() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element root = document.getRootElement();
		Element book = root.element("书");
		List<Element> list = book.elements();// [书名，作者，售价，售价]

		Element price = DocumentHelper.createElement("售价");
		price.setText("150元");

		list.add(2, price);

		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"), format);
		writer.write(document);
		writer.close();

	}

	// 删除上面添加的节点
	@Test
	public void delete() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element root = document.getRootElement();
		Element price = root.element("书").element("售价");
		price.getParent().remove(price);

		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"), format);
		writer.write(document);
		writer.close();
	}

	// 更新第二本书的作者
	@Test
	public void update() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element root = document.getRootElement();
		Element book = (Element) root.elements("书").get(1);
		book.element("作者").setText("帅哥");

		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"), format);
		writer.write(document);
		writer.close();
		
	}

}
