package cn.test.sax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Demo03 {
	/**
	 * sax ����xml�ĵ�
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		//1.������������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		//2.�õ�������
		SAXParser sp = factory.newSAXParser();
		
		//3.�õ���ȡ��
		XMLReader reader = sp.getXMLReader();
		
		//4.���ô�������
		BeanListHandler handler = new BeanListHandler();
		reader.setContentHandler(handler);
		
		//5.��ȡxml�ĵ�����
		reader.parse("src/book.xml");

		List<Book> list = handler.getBooks();

		for (Book book : list) {
			String name = book.getName();
			String author = book.getAuthor();
			String price = book.getPrice();
			System.out.println("������" + name);
			System.out.println("���ߣ�" + author);
			System.out.println("�ۼۣ�" + price);
		}
		
	}
}

//��xml�ĵ��е�ÿһ�����װ��һ��book���󣬲��Ѷ��book����ŵ�һ��list����
class BeanListHandler extends DefaultHandler{

	private List<Book> list = new ArrayList<Book>();
	private String currentTag; 
	private Book book;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		currentTag = qName;
		if ("��".equals(currentTag)) {
			book = new Book();
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if ("����".equals(currentTag)) {
			String name = new String(ch,start,length);
			book.setName(name);
		}
		if ("����".equals(currentTag)) {
			String author = new String(ch,start,length);
			book.setAuthor(author);
		}
		if ("�ۼ�".equals(currentTag)) {
			String price = new String(ch,start,length);
			book.setPrice(price);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(qName.equals("��")){
			list.add(book);
			book = null;
		}
		currentTag = null;	//С�Ŀ�ָ���쳣
	}

	public List<Book> getBooks() {
		return list;
	}	
}