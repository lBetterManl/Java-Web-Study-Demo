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

//ʹ��dom��ʽ��xml�ĵ�����crud 
public class Demo02 {

	// ��ȡxml�ĵ��У�<����>Java��ҵ</����> �ڵ��е�ֵ
	@Test
	public void read() throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/cn/test/xml/book0.xml");

		NodeList list = document.getElementsByTagName("����");
		Node node = list.item(0);

		String content = node.getTextContent();
		System.out.println(content);

	}

	// ��ȡxml�ĵ������б�ǩ
	@Test
	public void read2() throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/cn/test/xml/book0.xml");

		// �õ����ڵ�
		Node root = document.getElementsByTagName("���").item(0);
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

	// ��ȡxml�ĵ��б�ǩ���Ե�ֵ��
	@Test
	public void read3() throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/cn/test/xml/book0.xml");

		Element bookid = (Element) document.getElementsByTagName("����").item(0);
		String value = bookid.getAttribute("name");
		System.out.println(value);

	}

	// ��xml�ĵ�����ӽڵ�:<�ۼ�>59.00</�ۼ�>
	@Test
	public void add() throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/cn/test/xml/book0.xml");

		// �����ڵ�
		Element price = document.createElement("�ۼ�");
		price.setTextContent("59.00Ԫ");

		// �Ѵ����Ľڵ�ҵ���һ������

		Element book = (Element) document.getElementsByTagName("��").item(0);
		if (book != null) {

			book.appendChild(price);

			// �Ѹ��º���ڴ�д�ص�xml�ĵ�
			TransformerFactory tfFactory = TransformerFactory.newInstance();
			Transformer tf = tfFactory.newTransformer();
			tf.transform(new DOMSource(document), new StreamResult(
					new FileOutputStream("src/cn/test/xml/book0.xml")));
			System.out.println("haha");
		}

	}

	// ��xml�ĵ���ָ��λ����ӽڵ�:<�ۼ�>59.00</�ۼ�>
	@Test
	public void add2() throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/cn/test/xml/book0.xml");

		// �����ڵ�
		Element price = document.createElement("�ۼ�");
		price.setTextContent("59.00Ԫ");

		// �õ��ο��ڵ�
		Element refNode = (Element) document.getElementsByTagName("�ۼ�").item(0);

		// �õ�Ҫ���̵Ľڵ�
		Element book = (Element) document.getElementsByTagName("��").item(0);

		// ��book�ڵ��ָ��δ֪����
		book.insertBefore(price, refNode);

		// �Ѹ��º���ڴ�д�ص�xml�ĵ�
		TransformerFactory tfFactory = TransformerFactory.newInstance();
		Transformer tf = tfFactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream("src/cn/test/xml/book0.xml")));
		System.out.println("haha");

	}

	// ��xml�ĵ����������<���� name="XXX">Java��ҵ</����>
	@Test
	public void add3() throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/cn/test/xml/book0.xml");

		Element bookname = (Element) document.getElementsByTagName("��").item(0);
		bookname.setAttribute("name", "XXX");

		// �Ѹ��º���ڴ�д�ص�xml�ĵ�
		TransformerFactory tfFactory = TransformerFactory.newInstance();
		Transformer tf = tfFactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream("src/cn/test/xml/book0.xml")));
		System.out.println("haha");

	}

	// ��xml�ĵ���ɾ���ڵ�
	@Test
	public void del() throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/cn/test/xml/book0.xml");

		// �õ�Ҫɾ���Ľڵ�
		Element e = (Element) document.getElementsByTagName("�ۼ�").item(0);

		// �õ�Ҫɾ���ڵ�İְֽڵ�
		Element book = (Element) document.getElementsByTagName("��").item(0);

		// �ְ���ɾ��
		book.removeChild(e);

		// �Ѹ��º���ڴ�д�ص�xml�ĵ�
		TransformerFactory tfFactory = TransformerFactory.newInstance();
		Transformer tf = tfFactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream("src/cn/test/xml/book0.xml")));
		System.out.println("haha");

	}

	// ɾ����
	@Test
	public void del2() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/cn/test/xml/book0.xml");

		// ɾ���Լ�
		Element e = (Element) document.getElementsByTagName("�ۼ�").item(0);
		e.getParentNode().getParentNode().removeChild(e.getParentNode());

		// �Ѹ��º���ڴ�д�ص�xml�ĵ�
		TransformerFactory tfFactory = TransformerFactory.newInstance();
		Transformer tf = tfFactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream("src/cn/test/xml/book0.xml")));
		System.out.println("haha");
	}

	// �����ۼ�
	@Test
	public void update() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/cn/test/xml/book0.xml");

		Element e = (Element) document.getElementsByTagName("�ۼ�").item(0);
		e.setTextContent("109Ԫ");

		// �Ѹ��º���ڴ�д�ص�xml�ĵ�
		TransformerFactory tfFactory = TransformerFactory.newInstance();
		Transformer tf = tfFactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(
				new FileOutputStream("src/cn/test/xml/book0.xml")));
		System.out.println("haha");

	}
}
