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

	// dom4j��ȡxml�ĵ���2����ģ�<����>����</����>
	@Test
	public void read() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element root = document.getRootElement();
		Element book = (Element) root.elements("��").get(1);
		String value = book.element("����").getText();
		System.out.println(value);
	}

	// ��ȡxml�ĵ���1����ģ�<�� name="XXX">
	@Test
	public void read2() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element root = document.getRootElement();
		Element book = (Element) root.elements("��").get(0);
		String value = book.attributeValue("name");
		System.out.println(value);
	}

	// �ڵ�һ���������һ���µ��ۼۣ�<�ۼ�>59.00Ԫ</�ۼ�>
	@Test
	public void add() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element book = (Element) document.getRootElement().elements("��").get(0);
		book.addElement("�ۼ�").setText("59.00Ԫ");

		// ��ֹ���벻ʹ��FileWriter
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

	// �ڵ�һ������ָ��λ�����һ���µ��ۼۣ�<�ۼ�>209Ԫ</�ۼ�>
	@Test
	public void add2() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element book = document.getRootElement().element("��");
		@SuppressWarnings("unchecked")
		List<Element> list = book.elements(); // [���������ߣ��ۼ�]

		Element price = DocumentHelper.createElement("�ۼ�");
		price.setText("209Ԫ");

		list.add(2, price);
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"),
				format);

		writer.write(document);
		writer.close();
	}

	// ɾ��������ӵ��ۼ۽ڵ�
	@Test
	public void delete() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element price = document.getRootElement().element("��").element("�ۼ�");
		price.getParent().remove(price);

		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"),
				format);

		writer.write(document);
		writer.close();
	}

	// ���µڶ���������
	@Test
	public void update() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element book = (Element) document.getRootElement().elements("��").get(1);
		book.element("����").setText("����");

		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"),
				format);

		writer.write(document);
		writer.close();
	}

}
