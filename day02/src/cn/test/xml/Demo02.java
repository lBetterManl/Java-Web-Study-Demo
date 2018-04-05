package cn.test.xml;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//使用dom方式对xml文档进行crud 
public class Demo02 {

	// 获取xml文档中：<书名>Java就业</书名> 节点中的值
	@Test
	public void read() throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/cn/test/xml/book0.xml");

		NodeList list = document.getElementsByTagName("书名");
		Node node = list.item(0);

		String content = node.getTextContent();
		System.out.println(content);

	}

	// 获取xml文档中所有标签
	@Test
	public void read2() throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/cn/test/xml/book0.xml");

		// 得到根节点
		Node root = document.getElementsByTagName("书架").item(0);
		list(root);

	}

	public void list(Node node) {
		if (node instanceof Element)
			System.out.println(node.getNodeName());
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node child = list.item(i);
			list(child);
		}

	}

	// 获取xml文档中标签属性的值：
	@Test
	public void read3() throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/cn/test/xml/book0.xml");

		Element bookid = (Element) document.getElementsByTagName("书名").item(0);
		String value = bookid.getAttribute("name");
		System.out.println(value);

	}

	// 向xml文档中添加节点:<售价>59.00</售价>
	@Test
	public void add() throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/cn/test/xml/book0.xml");

		// 创建节点
		Element price = document.createElement("售价");
		price.setTextContent("59.00元");

		// 把创建的节点挂到第一本书上

		Element book = (Element) document.getElementsByTagName("书").item(0);
		if (book != null) {

			book.appendChild(price);

			// 把更新后的内存写回到xml文档
			TransformerFactory tfFactory = TransformerFactory.newInstance();
			Transformer tf = tfFactory.newTransformer();
			tf.transform(new DOMSource(document), new StreamResult(
					new FileOutputStream("src/cn/test/xml/book0.xml")));
			System.out.println("haha");
		}

	}

	// 向xml文档中指定位置添加节点:<售价>59.00</售价>
	@Test
	public void add2() throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/cn/test/xml/book0.xml");

		// 创建节点
		Element price = document.createElement("售价");
		price.setTextContent("59.00元");

		// 得到参考节点
		Element refNode = (Element) document.getElementsByTagName("售价").item(0);

		// 得到要挂崽的节点
		Element book = (Element) document.getElementsByTagName("书").item(0);

		// 往book节点的指定未知插崽
		book.insertBefore(price, refNode);

		// 把更新后的内存写回到xml文档
		TransformerFactory tfFactory = TransformerFactory.newInstance();
		Transformer tf = tfFactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream("src/cn/test/xml/book0.xml")));
		System.out.println("haha");

	}

	// 向xml文档中添加属性<书名 name="XXX">Java就业</书名>
	@Test
	public void add3() throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/cn/test/xml/book0.xml");

		Element bookname = (Element) document.getElementsByTagName("书").item(0);
		bookname.setAttribute("name", "XXX");

		// 把更新后的内存写回到xml文档
		TransformerFactory tfFactory = TransformerFactory.newInstance();
		Transformer tf = tfFactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream("src/cn/test/xml/book0.xml")));
		System.out.println("haha");

	}

	// 从xml文档中删除节点
	@Test
	public void del() throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/cn/test/xml/book0.xml");

		// 得到要删除的节点
		Element e = (Element) document.getElementsByTagName("售价").item(0);

		// 得到要删除节点的爸爸节点
		Element book = (Element) document.getElementsByTagName("书").item(0);

		// 爸爸再删崽
		book.removeChild(e);

		// 把更新后的内存写回到xml文档
		TransformerFactory tfFactory = TransformerFactory.newInstance();
		Transformer tf = tfFactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream("src/cn/test/xml/book0.xml")));
		System.out.println("haha");

	}

	// 删除书
	@Test
	public void del2() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/cn/test/xml/book0.xml");

		// 删除自己
		Element e = (Element) document.getElementsByTagName("售价").item(0);
		e.getParentNode().getParentNode().removeChild(e.getParentNode());

		// 把更新后的内存写回到xml文档
		TransformerFactory tfFactory = TransformerFactory.newInstance();
		Transformer tf = tfFactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream("src/cn/test/xml/book0.xml")));
		System.out.println("haha");
	}

	// 更新售价
	@Test
	public void update() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/cn/test/xml/book0.xml");

		Element e = (Element) document.getElementsByTagName("售价").item(0);
		e.setTextContent("109元");

		// 把更新后的内存写回到xml文档
		TransformerFactory tfFactory = TransformerFactory.newInstance();
		Transformer tf = tfFactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream("src/cn/test/xml/book0.xml")));
		System.out.println("haha");

	}
}
