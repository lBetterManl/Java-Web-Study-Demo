package cn.test.dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class Demo01 {

	// dom4j读取xml文档第2本书的：<书名>开发</书名>
	@Test
	public void read() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element root = document.getRootElement();
		Element book = (Element) root.elements("书").get(1);
		String value = book.element("书名").getText();
		System.out.println(value);
	}

	// 读取xml文档第1本书的：<书 name="XXX">
	@Test
	public void read2() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element root = document.getRootElement();
		Element book = (Element) root.elements("书").get(0);
		String value = book.attributeValue("name");
		System.out.println(value);
	}

	// 在第一本书上添加一个新的售价：<售价>59.00元</售价>
	@Test
	public void add() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element book = (Element) document.getRootElement().elements("书").get(0);
		book.addElement("售价").setText("59.00元");

		// 防止乱码不使用FileWriter
		// 1.
		// XMLWriter writer = new XMLWriter(new FileWriter("src/book.xml"));
		// 2.
		// XMLWriter writer = new XMLWriter(new OutputStreamWriter(new
		// FileOutputStream("src/book.xml"),"utf-8"));
		// 3.
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"),
				format);

		writer.write(document);
		writer.close();
	}

	// 在第一本书上指定位置添加一个新的售价：<售价>209元</售价>
	@Test
	public void add2() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element book = document.getRootElement().element("书");
		@SuppressWarnings("unchecked")
		List<Element> list = book.elements(); // [书名，作者，售价]

		Element price = DocumentHelper.createElement("售价");
		price.setText("209元");

		list.add(2, price);
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"),
				format);

		writer.write(document);
		writer.close();
	}

	// 删除上面添加的售价节点
	@Test
	public void delete() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element price = document.getRootElement().element("书").element("售价");
		price.getParent().remove(price);

		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"),
				format);

		writer.write(document);
		writer.close();
	}

	// 更新第二本书作者
	@Test
	public void update() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element book = (Element) document.getRootElement().elements("书").get(1);
		book.element("作者").setText("更新");

		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"),
				format);

		writer.write(document);
		writer.close();
	}

}
