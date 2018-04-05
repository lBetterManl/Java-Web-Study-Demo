package cn.test.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Demo02 {
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
		reader.setContentHandler(new TagValueHandler());
		
		//5.��ȡxml�ĵ�����
		reader.parse("src/book.xml");

	}
}

//�õ�xmlָ����ǩ��ֵ
class TagValueHandler extends DefaultHandler{

	private String currentTag;	//��ס��ǰ�������ı�ǩ
	private int needNum = 2;	//��ס���ȡ�ڼ������ߵı�ǩֵ
	private int currentNumber;	//��ǰ���������ǵڼ���
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		currentTag = qName;
		if (currentTag.equals("����")) {
			currentNumber++;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if ("����".equals(currentTag) && currentNumber==needNum) {
			System.out.println(new String(ch,start,length ));
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
	}	
		
}