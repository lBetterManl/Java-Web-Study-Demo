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
	 * sax 解析xml文档
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		//1.创建解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		//2.得到解析器
		SAXParser sp = factory.newSAXParser();
		
		//3.得到读取器
		XMLReader reader = sp.getXMLReader();
		
		//4.设置处理内容
		BeanListHandler handler = new BeanListHandler();
		reader.setContentHandler(handler);
		
		//5.读取xml文档内容
		reader.parse("src/book.xml");

		List<Book> list = handler.getBooks();

		for (Book book : list) {
			String name = book.getName();
			String author = book.getAuthor();
			String price = book.getPrice();
			System.out.println("书名：" + name);
			System.out.println("作者：" + author);
			System.out.println("售价：" + price);
		}
		
	}
}

//把xml文档中的每一本书封装到一个book对象，并把多个book对象放到一个list集合
class BeanListHandler extends DefaultHandler{

	private List<Book> list = new ArrayList<Book>();
	private String currentTag; 
	private Book book;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		currentTag = qName;
		if ("书".equals(currentTag)) {
			book = new Book();
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if ("书名".equals(currentTag)) {
			String name = new String(ch,start,length);
			book.setName(name);
		}
		if ("作者".equals(currentTag)) {
			String author = new String(ch,start,length);
			book.setAuthor(author);
		}
		if ("售价".equals(currentTag)) {
			String price = new String(ch,start,length);
			book.setPrice(price);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(qName.equals("书")){
			list.add(book);
			book = null;
		}
		currentTag = null;	//小心空指针异常
	}

	public List<Book> getBooks() {
		return list;
	}	
}